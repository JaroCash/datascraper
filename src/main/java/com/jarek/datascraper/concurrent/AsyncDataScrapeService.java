package com.jarek.datascraper.concurrent;

import com.jarek.datascraper.entity.Videogame;
import com.jarek.datascraper.parser.GryonlineParser;
import com.jarek.datascraper.service.VideogameService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsyncDataScrapeService {

    private final String AFTER_RELEASE_URL = "https://www.gry-online.pl/gry/02vh-";

    private GryonlineParser gryonlineParser;

    private VideogameService videogameService;

    public AsyncDataScrapeService(GryonlineParser gryonlineParser, VideogameService videogameService) {
        this.gryonlineParser = gryonlineParser;
        this.videogameService = videogameService;
    }

    @Async
    public void scrapeVideogamesInPageRange(int startPage, int endPage) {

        System.out.println( Thread.currentThread().getId() + Thread.currentThread().getName());
        List<Videogame> videogameList = gryonlineParser.getVideogamesInPagesRange(AFTER_RELEASE_URL, startPage, endPage);
        videogameService.saveVideogamesList(videogameList);
    }
}
