package com.jarek.datascraper.config;

import com.jarek.datascraper.exception.APIAuthenticationEntryPoint;
import com.jarek.datascraper.exception.APIAuthenticationFailureHandler;
import com.jarek.datascraper.security.APIKeyAuthenticationFilter;
import com.jarek.datascraper.security.APIKeyAuthenticationManager;
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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigAPIKey extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService appUserService;

    public APIKeyAuthenticationFilter authenticationFilter() throws Exception {
        APIKeyAuthenticationFilter filter = new APIKeyAuthenticationFilter();
        filter.setAuthenticationManager(new APIKeyAuthenticationManager(appUserService));
        filter.setAuthenticationFailureHandler(APIfailureHandler());
        return filter;
    }


    @Bean
    public AuthenticationFailureHandler APIfailureHandler() {
        return new APIAuthenticationFailureHandler("/exception");
    }



    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
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