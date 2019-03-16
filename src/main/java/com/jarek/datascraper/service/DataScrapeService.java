package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.Videogame;

import java.util.List;

public interface DataScrapeService {

    public void scrapeAllVideoGames();

    public void scrapeVideogamesAfterRelease();

    public void scrapeVideogamesBeforeRelease();

    public void scrapeVideogamesAfterReleaseThreads(int numberOfThreads);

//    public void scrapeVideogamesInPageRange(int start, int end);

}
