package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.VideogameDAO;
import com.jarek.datascraper.dao.VideogameRepository;
import com.jarek.datascraper.entity.Videogame;
import org.graalvm.util.ObjectSizeEstimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.instrument.Instrumentation;
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

//        theVideogamesList.forEach(videogame -> videogameRepository.save(videogame));


//                theVideogamesList.forEach(videogame -> {
//
//            if(!videogameRepository.existsByTitleAndReleaseDate(videogame.getTitle(),videogame.getReleaseDate()))
//            videogameRepository.save(videogame);});

        int id = 0;
        int size = 0;
        for (Videogame videogame : theVideogamesList) {

            try {
                id = videogameRepository.findByTitleAndReleaseDate(videogame.getTitle(), videogame.getReleaseDate())
                                        .getId();
                size = size + ObjectSizeEstimate.forObject(videogameRepository.findByTitleAndReleaseDate(videogame.getTitle(), videogame.getReleaseDate())).getTotalBytes();
                videogame.setId(id);
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }

//            videogame.setId(videogameRepository.findByTitleAndReleaseDate(videogame.getTitle(), videogame.getReleaseDate()).getId());
//            videogameRepository.findByTitleAndReleaseDate(videogame.getTitle(), videogame.getReleaseDate()).getId()
            System.out.println("ID to " + id);
//            System.out.println(ObjectSizeEstimate.forObject(videogameRepository.findByTitleAndReleaseDate(videogame.getTitle(), videogame.getReleaseDate())).getTotalBytes());
            videogameRepository.save(videogame);
        }
        System.out.println("Romiar listy to " + size );
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
