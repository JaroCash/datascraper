package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {

    AppUser findByLogin(String login);

    AppUser findByLoginAndApiKey(String login, String apiKey);

    AppUser findByApiKey(String apiKey);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);


}
