package com.jarek.datascraper.service;

import com.jarek.datascraper.dao.AppUserRepository;
import com.jarek.datascraper.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByLogin(login);

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(appUser.getRole()));

        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(appUser.getLogin(), appUser.getPassword(), authorities);
    }
}
