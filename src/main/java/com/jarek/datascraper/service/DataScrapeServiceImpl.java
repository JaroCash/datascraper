package com.jarek.datascraper.service;

import com.jarek.datascraper.concurrent.AsyncDataScrapeService;
import com.jarek.datascraper.entity.Videogame;
import com.jarek.datascraper.parser.GryonlineHelper;
import com.jarek.datascraper.parser.GryonlineParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataScrapeServiceImpl implements DataScrapeService {

    private final String AFTER_RELEASE_URL = "https://www.gry-online.pl/gry/02vh-";

    private final String BEFORE_RELEASE_URL = "https://www.gry-online.pl/gry/13vh-";

    private final String AFTER_RELEASE_PARASER_PARAM = "a[href=/gry/22]>stxt";

    private final String BEFORE_RELEASE_PARSER_PARAM = "a[href=/gry/33]>stxt";

    private GryonlineParser gryonlineParser;

    private VideogameService videogameService;

    private GryonlineHelper gryonlineHelper;

    private AsyncDataScrapeService asyncDataScrapeService;

    public DataScrapeServiceImpl(GryonlineParser gryonlineParser, VideogameService videogameService, GryonlineHelper gryonlineHelper, AsyncDataScrapeService asyncDataScrapeService) {
        this.gryonlineParser = gryonlineParser;
        this.videogameService = videogameService;
        this.gryonlineHelper = gryonlineHelper;
        this.asyncDataScrapeService = asyncDataScrapeService;
    }

    @Override
    public void scrapeAllVideoGames() {

        scrapeVideogamesAfterRelease();
        scrapeVideogamesBeforeRelease();
    }

    @Override
    public void scrapeVideogamesAfterRelease() {

        List<Videogame> videogameList =  gryonlineParser.getAllVideogames(AFTER_RELEASE_URL, AFTER_RELEASE_PARASER_PARAM);

        saveVideogamesList(videogameList);
    }

    //the number of games before release is significantly smaller than after release, no point to use multiple threads
    @Override
    public void scrapeVideogamesBeforeRelease() {

        List<Videogame> videogameList = gryonlineParser.getAllVideogames(BEFORE_RELEASE_URL, BEFORE_RELEASE_PARSER_PARAM );

        saveVideogamesList(videogameList);

    }

    @Override
    public void saveVideogamesList(List<Videogame> theVideogamesList) {

            videogameService.saveVideogamesList(theVideogamesList);

    }

    @Override
    public void scrapeVideogamesAfterReleaseUsingThreads(int numberOfThreads) {

        int numberOfPages = gryonlineHelper.countPages(AFTER_RELEASE_PARASER_PARAM);

        int[] pageRangeArr = gryonlineHelper.countPageRanges(numberOfPages, numberOfThreads);

        for (int i = 0; i < pageRangeArr.length - 1; i++) {

            System.out.println(pageRangeArr[i] + 1 + "  " + pageRangeArr[i + 1]);
            asyncDataScrapeService.scrapeVideogamesInPageRange(pageRangeArr[i] + 1, pageRangeArr[i + 1]);
        }
    }

//    @Async
//    public CompletableFuture<List<Videogame>> scrapeVideogamesInPageRange(int start, int end) {
//
//        System.out.println( Thread.currentThread().getId() + Thread.currentThread().getName());
//        List< Videogame> videogameList = gryonlineParser.getVideogamesInPagesRange(AFTER_RELEASE_URL, start, end);
//        videogameService.saveVideogamesList(videogameList);
//    }


}
