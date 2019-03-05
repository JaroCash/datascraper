package com.jarek.datascraper.service;

import com.jarek.datascraper.concurrent.AsyncDataScrapeService;
import com.jarek.datascraper.config.GryOnlineProperties;
import com.jarek.datascraper.entity.Videogame;
import com.jarek.datascraper.parser.GryonlineHelper;
import com.jarek.datascraper.parser.GryonlineParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataScrapeServiceImpl implements DataScrapeService {

    private GryonlineParser gryonlineParser;

    private VideogameService videogameService;

    private GryonlineHelper gryonlineHelper;

    private AsyncDataScrapeService asyncDataScrapeService;

    private GryOnlineProperties properties;

    @Autowired
    public DataScrapeServiceImpl(GryonlineParser gryonlineParser, VideogameService videogameService,
                                 GryonlineHelper gryonlineHelper, AsyncDataScrapeService asyncDataScrapeService, GryOnlineProperties properties) {
        this.gryonlineParser = gryonlineParser;
        this.videogameService = videogameService;
        this.gryonlineHelper = gryonlineHelper;
        this.asyncDataScrapeService = asyncDataScrapeService;
        this.properties = properties;
    }

    @Override
    public void scrapeAllVideoGames() {

        scrapeVideogamesAfterRelease();
        scrapeVideogamesBeforeRelease();
    }

    @Override
    public void scrapeVideogamesAfterRelease() {

        List<Videogame> videogameList =  gryonlineParser.getAllVideogames(properties.getAfterReleaseURL(), properties.getAfterReleaseParserParam());

        saveVideogamesList(videogameList);
    }

    //the number of games before release is significantly smaller than after release, no point to use multiple threads
    @Override
    public void scrapeVideogamesBeforeRelease() {

        List<Videogame> videogameList = gryonlineParser.getAllVideogames(properties.getBeforeReleaseURL(), properties.getBeforeReleaseParserParam() );

        saveVideogamesList(videogameList);

    }

    @Override
    public void saveVideogamesList(List<Videogame> theVideogamesList) {

            videogameService.saveVideogamesList(theVideogamesList);

    }

    @Override
    public void scrapeVideogamesAfterReleaseUsingThreads(int numberOfThreads) {

        int numberOfPages = gryonlineHelper.countPages(properties.getAfterReleaseURL());

        int[] pageRangeArr = gryonlineHelper.countPageRanges(numberOfPages, numberOfThreads);

        for (int i = 0; i < pageRangeArr.length - 1; i++) {

            System.out.println(pageRangeArr[i] + 1 + "  " + pageRangeArr[i + 1]);
            asyncDataScrapeService.scrapeVideogamesInPageRange(pageRangeArr[i] + 1, pageRangeArr[i + 1]);
        }
    }


}
