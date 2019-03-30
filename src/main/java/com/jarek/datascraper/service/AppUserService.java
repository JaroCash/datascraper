package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface AppUserService {

    AppUser findByLogin(String login);

    AppUser findByApiKey(String apiKey);

    void saveAppUser(AppUser appUser);

    void registerAppUser(UserDTO userDTO);

}
