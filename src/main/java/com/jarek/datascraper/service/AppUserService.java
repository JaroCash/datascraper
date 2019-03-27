package com.jarek.datascraper.service;

import com.jarek.datascraper.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;

public interface AppUserService {

    AppUser findByApiKey(String apiKey);

}
