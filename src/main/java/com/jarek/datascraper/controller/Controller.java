package com.jarek.datascraper.controller;

import com.jarek.datascraper.concurrent.AsyncDataScrapeService;
import com.jarek.datascraper.concurrent.DataScraperThreadRunner;
import com.jarek.datascraper.entity.Videogame;
import com.jarek.datascraper.service.AppUserServiceImpl;
import com.jarek.datascraper.service.DataScrapeService;
import com.jarek.datascraper.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private DataScrapeService dataScrapeService;

    private VideogameService videogameService;

    public DataScraperThreadRunner dataScraperThreadRunner;

    private AsyncDataScrapeService asyncDataScrapeService;

    private AppUserServiceImpl appUserService;

    @Autowired
    public Controller(DataScrapeService dataScrapeService, VideogameService videogameService, AsyncDataScrapeService asyncDataScrapeService, AppUserServiceImpl appUserService) {
        this.dataScrapeService = dataScrapeService;
        this.videogameService = videogameService;
        this.asyncDataScrapeService = asyncDataScrapeService;
        this.appUserService = appUserService;
    }

    @GetMapping("/before")
    public String scrapeBeforeRelease() {

        dataScrapeService.scrapeVideogamesBeforeRelease();

        return "before release";
    }

    @GetMapping("/title")
    public List<Videogame> findByTitle() {

        List<Videogame> videoGameTitle = videogameService.findByTitle("Hyper Jam");

        System.out.println(appUserService.loadUserByUsername("n1"));

        return videoGameTitle;
    }

    @GetMapping("/platform/{platformName}")
    public List<Videogame> findByPlatform(@PathVariable String platformName) {

        List<Videogame> videoGameByPlatform = videogameService.findByPlatformsContains(platformName);

        return videoGameByPlatform;
    }

    @GetMapping("/genre/{genreName}")
    public List<Videogame> findByGenre(@PathVariable String genreName) {

        List<Videogame> videoGameByPlatform = videogameService.findByGenreContains(genreName);

        return videoGameByPlatform;
    }

    @GetMapping("/thread")
    public void runThread() {
        long start = System.nanoTime();


        try {
            dataScrapeService.scrapeVideogamesAfterReleaseUsingThreads(10);
            System.out.println(Thread.activeCount());

        } catch (Exception e) {
            e.printStackTrace();
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println( elapsedTime);
    }

    @GetMapping("/hello")
    public String helloWorld() {

        long start = System.nanoTime();
        dataScrapeService.scrapeVideogamesAfterRelease();
        long elapsedTime = System.nanoTime() - start;
        System.out.println( elapsedTime);

        return "gry po premierze";
    }
}
