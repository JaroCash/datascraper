package com.jarek.datascraper.controller;

import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.service.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@SpringBootTest(classes = ApicreatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
//@WebMvcTest(LoginController.class)
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    AppUserService appUserService;

    @Test
    public void shouldReturnString() throws Exception {

        when(appUserService.findByApiKey("token")).thenReturn(new AppUser("token"));

        this.mockMvc.perform(get("/api/title")
                .header("Authentication", "token")
                .contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRegisterUser() throws Exception {

        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("login", "login");
        paramsMap.add("email", "email@gmail.com");
        paramsMap.add("password", "password");
        paramsMap.add("matchingPassword", "password");


        this.mockMvc.perform(post("/processRegister").params(paramsMap))
                    .andExpect(redirectedUrl("/registerPage"));
    }


}
