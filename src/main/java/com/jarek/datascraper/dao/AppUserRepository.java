package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {

    AppUser findByLogin(String login);

    AppUser findByApiKey(String apiKey);


}
