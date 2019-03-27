package com.jarek.datascraper.security;

import com.jarek.datascraper.dao.AppUserRepository;
import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


public class APIKeyAuthenticationManager implements AuthenticationManager {

    private AppUserService appUserService;

    public APIKeyAuthenticationManager(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        AppUser tempAppUser = appUserService.findByApiKey(authentication.getPrincipal().toString());

        if (tempAppUser!=null) {
        authentication.setAuthenticated(true);

        } else {
                    authentication.setAuthenticated(false);
                    throw new BadCredentialsException("Bad token");
        }

        return authentication;
    }
}
