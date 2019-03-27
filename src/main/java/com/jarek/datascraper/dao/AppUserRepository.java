package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.security.CustomAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {

    AppUser findByLoginAndApiKey(String login, String apiKey);

    AppUser findByApiKey(String apiKey);


}
