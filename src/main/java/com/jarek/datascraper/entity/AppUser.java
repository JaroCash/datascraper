package com.jarek.datascraper.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "api_key")
    private String apiKey;

    public AppUser() {
    }

    public AppUser(String apiKey) {
        this.apiKey = apiKey;
    }

    public AppUser(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public AppUser(String login, String password, String role, String apiKey) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.apiKey = apiKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}

