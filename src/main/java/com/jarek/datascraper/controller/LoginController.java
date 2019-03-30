package com.jarek.datascraper.controller;

import com.jarek.datascraper.entity.UserDTO;
import com.jarek.datascraper.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.AccessDeniedException;

@Controller
//@RequestMapping("/")
public class LoginController {

    private AppUserService appUserService;

    @Autowired
    public LoginController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/loginPage")
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

    @GetMapping("/registerPage")
    public String showRegisterPage(Model model) {

        model.addAttribute("user", new UserDTO());

        return "register";
    }

    @PostMapping("/processRegister")
    public void processRegister(@ModelAttribute("user") UserDTO userDTO) {

    appUserService.registerAppUser(userDTO);

    }
}
