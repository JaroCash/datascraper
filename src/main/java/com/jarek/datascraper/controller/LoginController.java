package com.jarek.datascraper.controller;

import com.jarek.datascraper.entity.UserDTO;
import com.jarek.datascraper.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    private AppUserService appUserService;

    @Autowired
    public LoginController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/errorr")
    public String showErrorPage() {
        return "er";
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
    public String processRegister(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
//        if (appUserService.existsInDatabase(userDTO)) {
//
//        }

    String apiKey = appUserService.registerAppUser(userDTO);

    redirectAttributes.addFlashAttribute("message", "Successfully registered. You can now log in. Your API key is: "+apiKey);

    return "redirect:/registerPage";

    }
}
