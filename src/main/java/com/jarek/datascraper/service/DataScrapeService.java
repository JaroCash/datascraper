package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.Videogame;

import java.util.List;

public interface DataScrapeService {

    void scrapeAllVideoGames();

    void scrapeVideogamesAfterRelease();

    void scrapeVideogamesBeforeRelease();

   void scrapeVideogamesAfterReleaseThreads(int numberOfThreads);


}
