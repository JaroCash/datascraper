package com.jarek.datascraper.parser;

import com.jarek.datascraper.entity.Videogame;


import java.util.List;

public interface GryonlineParser {

    public List<Videogame> getVideogamesFromPage(String url);

    public List<Videogame> getAllVideogames(String url, String parserParam);

    public List<Videogame> getVideogamesInPagesRange(String urk, int start, int end);

}
