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
        String dateStr = String.valueOf(dt);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dt);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        return sdf.format(calendar.getTime());
    }

    public WeatherMain getMain() {
        return main;
    }
}
