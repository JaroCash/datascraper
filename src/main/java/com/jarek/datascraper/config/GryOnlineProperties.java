package com.jarek.datascraper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="gryonline")
public class GryOnlineProperties {

    private String beforeReleaseURL;

    private String afterReleaseURL;

    private String beforeReleaseParserParam;

    private String afterReleaseParserParam;

    private String pageCountURL;

    public String getBeforeReleaseURL() {
        return beforeReleaseURL;
    }

    public void setBeforeReleaseURL(String beforeReleaseURL) {
        this.beforeReleaseURL = beforeReleaseURL;
    }

    public String getAfterReleaseURL() {
        return afterReleaseURL;
    }

    public void setAfterReleaseURL(String afterReleaseURL) {
        this.afterReleaseURL = afterReleaseURL;
    }

    public String getBeforeReleaseParserParam() {
        return beforeReleaseParserParam;
    }

    public void setBeforeReleaseParserParam(String beforeReleaseParserParam) {
        this.beforeReleaseParserParam = beforeReleaseParserParam;
    }

    public String getAfterReleaseParserParam() {
        return afterReleaseParserParam;
    }

    public void setAfterReleaseParserParam(String afterReleaseParserParam) {
        this.afterReleaseParserParam = afterReleaseParserParam;
    }

    public String getPageCountURL() {
        return pageCountURL;
    }

    public void setPageCountURL(String pageCountURL) {
        this.pageCountURL = pageCountURL;
    }
}
