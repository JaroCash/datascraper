package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideogameRepository extends JpaRepository<Videogame, Integer> {

    List<Videogame> findByTitle(String title);

    List<Videogame> findByPlatformsContains(String platform);

    List<Videogame> findByGenreContains(String genre);

}


