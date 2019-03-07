package com.jarek.datascraper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@EnableConfigurationProperties
@ConfigurationProperties(prefix="gryonline.parser")
public class PageParserProperties {

    private String titleParam;

    private String genreParam;

    private String releaseDateParam;

    private String descriptionParam;

    private String platformParam;

    public String getTitleParam() {
        return titleParam;
    }

    public void setTitleParam(String titleParam) {
        this.titleParam = titleParam;
    }

    public String getGenreParam() {
        return genreParam;
    }

    public void setGenreParam(String genreParam) {
        this.genreParam = genreParam;
    }

    public String getReleaseDateParam() {
        return releaseDateParam;
    }

    public void setReleaseDateParam(String releaseDateParam) {
        this.releaseDateParam = releaseDateParam;
    }

    public String getDescriptionParam() {
        return descriptionParam;
    }

    public void setDescriptionParam(String descriptionParam) {
        this.descriptionParam = descriptionParam;
    }

    public String getPlatformParam() {
        return platformParam;
    }

    public void setPlatformParam(String platformParam) {
        this.platformParam = platformParam;
    }
}
