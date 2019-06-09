package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherStatus implements Serializable {

    private long id;
    private String main;
    private String description;
    private String icon;

    public WeatherStatus() {
        this.id = -1;
        this.main = "";
        this.description = "";
        this.icon = "";
    }

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
