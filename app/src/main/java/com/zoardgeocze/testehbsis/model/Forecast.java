package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast implements Serializable {

    public long dt;
    public WeatherMain main = new WeatherMain();
    public List<WeatherStatus> weather = new ArrayList<>();


    public long getDt() {
        return dt;
    }

    public String getDateView() {
        Date date = new java.util.Date(dt*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-3"));

        return sdf.format(date);
    }

    public WeatherMain getMain() {
        return main;
    }
}
