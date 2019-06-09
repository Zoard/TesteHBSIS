package com.zoardgeocze.testehbsis.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse implements Serializable {

    public long id;
    public String name;
    public WeatherMain main;
    public List<WeatherStatus> weather = new ArrayList<>();


}
