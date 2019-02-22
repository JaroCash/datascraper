//package com.jarek.datascraper.config;
//
//import com.jarek.datascraper.security.TokenBasedAuthenticationFilter;
//import com.jarek.datascraper.security.TokenBasedAuthorizationFilter;
//import com.jarek.datascraper.service.AppUserService;
//import com.jarek.datascraper.service.AppUserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import javax.sql.DataSource;
//
////@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        // ensure the passwords are encoded properly
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
//        return manager;
//    }
//
//
//    @Configuration
//    @Order(1)
//    public static class WebConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        public WebConfigurationAdapter() {
//            super();
//        }
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                .antMatchers("/genre/**")
//                .hasAuthority("ROLE_USER")
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .disable()
//                .csrf()
//                .disable();
//        }
//
////        @Autowired
////        AppUserServiceImpl userDetailsService;
//
////        @Override
////        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//////            auth.userDetailsService(userDetailsService)
//////                .passwordEncoder(passwordEncoder());
//////        auth.authenticationProvider(authenticationProvider());
////                  auth.inMemoryAuthentication().withUser("tom").password(passwordEncoder().encode("abc123")).roles("USER");
////        }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
////    }
//
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////            .antMatchers("/api/**")
////            .hasRole("USER");
////    }
//
//
////                @Bean
////                public DaoAuthenticationProvider authenticationProvider() {
////                    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////                    authenticationProvider.setUserDetailsService(userDetailsService);
////                    authenticationProvider.setPasswordEncoder(passwordEncoder());
////                    return authenticationProvider;
////                }
//
//
//    }
//
//    @Configuration
//    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        public ApiConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                .antMatchers("/platform/**")
//                .hasAuthority("ROLE_ADMIN")
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .disable()
//                .csrf()
//                .disable();
//        }
//
////        @Override
////        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//////            auth.userDetailsService(userDetailsService)
//////                .passwordEncoder(passwordEncoder());
//////        auth.authenticationProvider(authenticationProvider());
////                  auth.inMemoryAuthentication().withUser("tom").password(passwordEncoder().encode("abc123")).roles("ADMIN");
////        }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
////    }
//
//
//
////        @Bean
////        public static PasswordEncoder passwordEncoder2() {
////            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
////        }
//
//
//
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//}
