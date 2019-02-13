package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.Videogame;

import java.util.List;

public interface DataScrapeService {

    public void scrapeAllVideoGames();

    public void scrapeVideogamesAfterRelease();

    public void scrapeVideogamesBeforeRelease();

    public void saveVideogamesList(List<Videogame> theVideogamesList);

    public void scrapeVideogamesAfterReleaseUsingThreads(int numberOfThreads);

//    public void scrapeVideogamesInPageRange(int start, int end);

}
