package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.security.CustomAppUser;
import org.springframework.data.jpa.repository.JpaRepository;


/////////////////// jedna implementacja!!!!
public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {


    AppUser findByLogin(String login);

    AppUser findByLoginAndApiKey(String login, String apiKey);

    boolean existsByApiKey(String apiKey);

    AppUser findByApiKey(String apiKey);


}
