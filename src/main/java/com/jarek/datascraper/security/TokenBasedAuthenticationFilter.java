package com.jarek.datascraper.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class TokenBasedAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    static final long TOKEN_LIFETIME = 900000;
    static final String TOKEN_PREFIX = "Bearer ";
    static final String TOKEN_SECRET_KEY = "TokenKey";

    public TokenBasedAuthenticationFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
                           .setId(UUID.randomUUID().toString())
                            .setSubject(((User) authResult.getPrincipal()).getUsername())
                            .setExpiration(new Date(System.currentTimeMillis()+ TOKEN_LIFETIME))
                            .signWith(SignatureAlgorithm.ES512, TOKEN_SECRET_KEY)
                            .compact();

        response.addHeader(HttpHeaders.AUTHORIZATION, TOKEN_PREFIX + token);

    }
}
