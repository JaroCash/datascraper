package com.jarek.datascraper.security;

import com.jarek.datascraper.exception.APIAuthenticationEntryPoint;
import com.jarek.datascraper.exception.APIAuthenticationFailureHandler;
import com.jarek.datascraper.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private APIKeyService apiKeyService;


    public APIAuthenticationFilter authenticationFilter() throws Exception {
        APIAuthenticationFilter filter = new APIAuthenticationFilter();
        filter.setAuthenticationManager(new APIAuthenticationManager(appUserService,apiKeyService));
        filter.setAuthenticationFailureHandler(APIfailureHandler());
        return filter;
    }

    @Bean
    public AuthenticationFailureHandler APIfailureHandler() {
        return new APIAuthenticationFailureHandler("/exception");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilterBefore(authenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
            .authorizeRequests()
            .antMatchers("/api/**")
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint());
//                            and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }


    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new APIAuthenticationEntryPoint();
    }

}