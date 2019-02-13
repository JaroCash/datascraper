package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.Videogame;

import java.util.List;

public interface VideogameService {

     void saveVideogamesList(List<Videogame> theVideogamesList);

     List<Videogame> findByTitle(String title);

     List<Videogame> findByPlatformsContains(String platform);

     List<Videogame> findByGenreContains(String genre);
}
