package com.jarek.datascraper.dao;

import com.jarek.datascraper.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


/////////////////// jedna implementacja!!!!
public interface AppUserRepository  extends JpaRepository<AppUser, String> {

    AppUser findByLogin(String login);


}
