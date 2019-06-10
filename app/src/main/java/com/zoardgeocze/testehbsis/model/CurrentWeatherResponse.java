package com.zoardgeocze.testehbsis.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse implements Serializable {

    public long id;
    public String name;
    public WeatherMain main;
    public List<WeatherStatus> weather = new ArrayList<>();
    public long dt;

    public String getDateView() {

        Date date = new java.util.Date(dt*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-3"));

        return sdf.format(date);
    }


}
