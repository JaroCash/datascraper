package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.VideogameRepository;
import com.jarek.datascraper.entity.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameServiceImpl implements VideogameService {

    private VideogameRepository videogameRepository;

    @Autowired
    public VideogameServiceImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }


    @Override
    public void saveVideogamesList(List<Videogame> theVideogamesList) {

        int id;
        for (Videogame videogame : theVideogamesList) {
            try {
                id = videogameRepository.findFirstByTitle(videogame.getTitle())
                                        .getId();
                videogame.setId(id);
            } catch (NullPointerException ex) {
                System.out.println("Creating new videogame entry");;
            }
            videogameRepository.save(videogame);
        }
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
