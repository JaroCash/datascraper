package com.jarek.datascraper.concurrent;

import com.jarek.datascraper.config.GryOnlineProperties;
import com.jarek.datascraper.entity.Videogame;
import com.jarek.datascraper.parser.GryonlineParser;
import com.jarek.datascraper.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsyncDataScrapeService {

    private GryOnlineProperties properties;

    private GryonlineParser gryonlineParser;

    private VideogameService videogameService;

    @Autowired
    public AsyncDataScrapeService(GryOnlineProperties properties, GryonlineParser gryonlineParser, VideogameService videogameService) {
        this.properties = properties;
        this.gryonlineParser = gryonlineParser;
        this.videogameService = videogameService;
    }

    @Async
    public void scrapeVideogamesInPageRange(int startPage, int endPage) {

        System.out.println( Thread.currentThread().getId() + Thread.currentThread().getName());
        List<Videogame> videogameList = gryonlineParser.getVideogamesInPagesRange(properties.getAfterReleaseURL(), startPage, endPage);
        videogameService.saveVideogamesList(videogameList);
    }
}
