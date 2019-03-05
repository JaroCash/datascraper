//package com.jarek.datascraper.config;
//
//import com.jarek.datascraper.service.AppUserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
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
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class MultiHttpSecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password(encoder().encode("userPass")).roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(encoder().encode("adminPass")).roles("ADMIN").build());
//        return manager;
//    }
//
//    @Bean
//    public static AuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
//        return new LoginUrlAuthenticationEntryPoint("/log");
//    }
//
//    @Bean
//    public static PasswordEncoder encoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Configuration
//    @Order(1)
//    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        AppUserServiceImpl userDetailsService;
//
//        public App1ConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////            auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("admin")).roles("ADMIN");
//            auth.userDetailsService(userDetailsService)
//                .passwordEncoder(encoder());
//        }
//
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/api/**")
//                .authorizeRequests()
//                .anyRequest()
//                .hasRole("ADMIN")
//                // log in
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
//                .and()
//                .exceptionHandling()
//                .defaultAuthenticationEntryPointFor(
//                        loginUrlAuthenticationEntryPoint(), new AntPathRequestMatcher("/api/title/**")
//                );
////                // logout
////                .and()
////                .logout()
////                .logoutUrl("/admin_logout")
////                .logoutSuccessUrl("/protectedLinks")
////                .deleteCookies("JSESSIONID")
////                .and()
////                .exceptionHandling()
////                .accessDeniedPage("/403")
////                .and()
////                .csrf()
////                .disable();
//        }
//    }
//
//    @Configuration
//    @Order(2)
//    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//
//        public App2ConfigurationAdapter() {
//            super();
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication().withUser("user").password(encoder().encode("user")).roles("ADMIN");
//        }
//
//        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/web/**").authorizeRequests().anyRequest().hasRole("ADMIN")
//                // log in
//                .and().httpBasic()
//                // logout
//                .and().logout().logoutUrl("/user_logout").logoutSuccessUrl("/protectedLinks").deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
//        }
//    }
//
//}