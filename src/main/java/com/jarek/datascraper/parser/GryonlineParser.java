package com.jarek.datascraper.parser;

import com.jarek.datascraper.entity.Videogame;


import java.util.List;

public interface GryonlineParser {

     List<Videogame> getVideogamesFromPage(String url);

     List<Videogame> getAllVideogames(String url, String parserParam);

    List<Videogame> getVideogamesInPagesRange(String urk, int start, int end);

}
