package com.jarek.datascraper.entity;

import javax.persistence.*;

@Entity
@Table(name= "videogame")
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "platforms")
    private String platforms;

    public Videogame() {
    }

    public Videogame(String title, String releaseDate, String genre, String description, String platforms) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
        this.platforms = platforms;
    }

    public Videogame(String title, String releaseDate, String genre, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
    }

    public Videogame(String title, String releaseDate, String genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Videogame(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", platforms='" + platforms + '\'' +
                '}';
    }
}
