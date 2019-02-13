package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.Videogame;

import java.util.List;

public interface VideogameDAO {

    public void save(Videogame theVideogame);

    public void saveVideogamesList(List<Videogame> theVideogamesList);

}
