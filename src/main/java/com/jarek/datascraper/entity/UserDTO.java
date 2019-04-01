package com.jarek.datascraper.entity;

import com.jarek.datascraper.validation.PasswordMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@PasswordMatch
public class UserDTO {

    @NotNull(message = "Field cannot be empty")
    @Size(min = 4, message = "Login must be at least 4 character long")
    private String login;

    @Email(message = "Enter correct email")
    @NotNull(message = "Field cannot be empty")
    private String email;

    @NotNull(message = "Field cannot be empty")
    @Size(min = 4, message = "Password must be at least 4 character long")
    private String password;

    @NotNull(message = "Field cannot be empty")
    @Size(min = 4, message = "Password must be at least 4 character long")
    private String matchingPassword;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
