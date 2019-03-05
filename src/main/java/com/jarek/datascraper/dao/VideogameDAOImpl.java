//package com.jarek.datascraper.dao;
//
//import com.jarek.datascraper.entity.Videogame;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public class VideogameDAOImpl implements VideogameDAO {
//
//    private EntityManager entityManager;
//
//    @Autowired
//    public VideogameDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    @Transactional
//    public void save(Videogame theVideogame) {
//
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        currentSession.saveOrUpdate(theVideogame);
//
//    }
//
//    @Override
//    @Transactional
//    public void saveVideogamesList(List<Videogame> theVideogamesList) {
//
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        for (Videogame tempVideogame : theVideogamesList) {
//            currentSession.saveOrUpdate(tempVideogame);
//
//        }
//    }
//}
