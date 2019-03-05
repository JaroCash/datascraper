package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.VideogameDAO;
import com.jarek.datascraper.dao.VideogameRepository;
import com.jarek.datascraper.entity.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameServiceImpl implements VideogameService {

    private VideogameRepository videogameRepository;

//    private VideogameDAO videogameDAO;

    @Autowired
    public VideogameServiceImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }


    @Override
    public void saveVideogamesList(List<Videogame> theVideogamesList) {

        theVideogamesList.forEach(videogame -> videogameRepository.save(videogame));

    }

    @Override
    public List<Videogame> findByTitle(String title) {

        return videogameRepository.findByTitle(title);
    }

    @Override
    public List<Videogame> findByPlatformsContains(String platform) {

        return videogameRepository.findByPlatformsContains(platform);
    }

    @Override
    public List<Videogame> findByGenreContains(String genre) {

        return videogameRepository.findByGenreContains(genre);
    }
}
