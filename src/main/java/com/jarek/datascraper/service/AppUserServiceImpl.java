package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.AppUserRepository;
import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.entity.UserDTO;
import com.jarek.datascraper.security.APIKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepository appUserRepository;

    private APIKeyService apiKeyService;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, APIKeyService apiKeyService) {
        this.appUserRepository = appUserRepository;
        this.apiKeyService = apiKeyService;
    }

    @Override
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }

    @Override
    public AppUser findByApiKey(String apiKey) {
        return appUserRepository.findByApiKey(apiKey);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public String registerAppUser(UserDTO userDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);

        AppUser appUser = new AppUser();

        String apiKey = apiKeyService.generateKey();

        appUser.setLogin(userDTO.getLogin());
        appUser.setEmail(userDTO.getEmail());
        appUser.setPassword("{bcrypt}" + passwordEncoder.encode(userDTO.getPassword()));
        appUser.setApiKey(apiKeyService.generateDigest(apiKey));
        appUser.setRole("ROLE_USER");

        appUserRepository.save(appUser);

        return apiKey;
    }

    @Override
    public boolean existsByLogin(String login) {
        return appUserRepository.existsByLogin(login);
    }

    @Override
    public boolean existsByEmail(String email) {
        return appUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existsInDatabase(UserDTO userDTO) {

        return (appUserRepository.existsByEmail(userDTO.getEmail()) && appUserRepository.existsByLogin(userDTO.getLogin()));
    }

}
