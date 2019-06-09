package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain implements Serializable {

    private double temp;
    private double pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;

    public WeatherMain() {
        this.temp = 0.0;
        this.pressure = 0.0;
        this.humidity = 0;
        this.temp_min = 0.0;
        this.temp_max = 0.0;
    }

    public double getTemp() { return temp; }

    public double getTemp_min() { return temp_min; }

    public double getTemp_max() {
        return temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
