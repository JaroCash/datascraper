package com.jarek.datascraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.AccessDeniedException;

@Controller
//@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "elo";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/exception")
    public String showExceptionPage() {


        return "error";
    }

}
