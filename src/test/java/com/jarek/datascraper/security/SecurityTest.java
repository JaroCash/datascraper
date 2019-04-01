package com.jarek.datascraper.security;


import com.jarek.datascraper.entity.AppUser;
import com.jarek.datascraper.service.AppUserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    AppUserService appUserService;

    @Test
    public void shouldReturnOKStatus() throws Exception {

        when(appUserService.findByApiKey("apiKey")).thenReturn(new AppUser("apiKey"));

        this.mockMvc.perform(get("/api/title")
                .header("Authentication", "apiKey")
                .contentType("application/json;charset=UTF-8"))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnRedirectStatus() throws Exception {

        when(appUserService.findByApiKey("apiKey")).thenReturn(new AppUser("apiKey"));

        this.mockMvc.perform(get("/api/title")
                .header("Authentication", "Key")
                .contentType("application/json;charset=UTF-8"))
                    .andDo(print())
                    .andExpect(status().is3xxRedirection());

    }

}
