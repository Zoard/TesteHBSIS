package com.zoardgeocze.testehbsis.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse implements Serializable {

    public List<CurrentWeather> list = new ArrayList<>();

}
