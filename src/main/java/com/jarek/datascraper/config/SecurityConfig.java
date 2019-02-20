package com.jarek.datascraper.config;

import com.jarek.datascraper.security.TokenBasedAuthenticationFilter;
import com.jarek.datascraper.security.TokenBasedAuthorizationFilter;
import com.jarek.datascraper.service.AppUserService;
import com.jarek.datascraper.service.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Configuration
    public static class WebConfigurationAdapter extends WebSecurityConfigurerAdapter {


        @Autowired
        AppUserServiceImpl userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(authenticationProvider());
            //      auth.inMemoryAuthentication().withUser("tom").password(passwordEncoder().encode("abc123")).roles("USER");
        }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
//    }

        //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest()
//            .hasAuthority("ROLE_USER")
//            .and()
//            .httpBasic()
//            .and()
//            .sessionManagement()
//            .disable()
//            .csrf()
//            .disable();
//    }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic()
                .disable()
                .formLogin()
                .disable()
                .logout()
                .disable()
                .addFilter(new TokenBasedAuthenticationFilter(authenticationManager()))
                .addFilter(new TokenBasedAuthorizationFilter(authenticationManager()));

            http.authorizeRequests()
                .antMatchers("/api/**")
                .authenticated();
        }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/api/**")
//            .hasRole("USER");
//    }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailsService);
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return authenticationProvider;
        }

    }

    @Configuration
    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

    }


}
