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

    private VideogameDAO videogameDAO;

    @Autowired
    public VideogameServiceImpl(VideogameRepository videogameRepository, VideogameDAO videogameDAO) {
        this.videogameRepository = videogameRepository;
        this.videogameDAO = videogameDAO;
    }

    @Override
    public void saveVideogamesList(List<Videogame> theVideogamesList) {

        videogameDAO.saveVideogamesList(theVideogamesList);

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
