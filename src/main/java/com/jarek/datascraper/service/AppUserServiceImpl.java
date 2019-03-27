package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.AppUserRepository;
import com.jarek.datascraper.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser findByApiKey(String apiKey) {
        return appUserRepository.findByApiKey(apiKey);
    }

}
