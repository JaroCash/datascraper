package com.jarek.datascraper.security;

import com.jarek.datascraper.dao.AppUserRepository;
import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        AppUser appUser = appUserService.findByLogin(login);

        if (login == null) {
            throw new UsernameNotFoundException(login);
        }
        return new AppUserPrincipal(appUser);
    }

}
