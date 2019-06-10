package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain implements Serializable {

    private double temp;
    private double pressure;
    private double humidity;
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

    public double getHumidity() {
        return humidity;
    }

    public String getTempView() { return String.valueOf((int)Math.ceil(temp) + "º");}

    public String getTempMinView() { return String.valueOf((int)Math.floor(temp_min) + "º"); }

    public String getTempMaxView() {
        return String.valueOf((int)Math.ceil(temp_max) + "º");
    }

    public String getPressureView() {
        DecimalFormat df1 = new DecimalFormat("#.#");
        return String.valueOf(df1.format(pressure));
    }

    public String getHumidityView() {
        DecimalFormat df1 = new DecimalFormat("#.#");
        return String.valueOf(df1.format(humidity)) + "%";
    }

    public void setAverage(double temp, double temp_max, double temp_min, double pressure, double humidity) {
        double forecastPerDay = 8.0;

        this.temp = temp/forecastPerDay;
        this.temp_max = temp_max/forecastPerDay;
        this.temp_min = temp_min/forecastPerDay;
        this.pressure = pressure/forecastPerDay;
        this.humidity = humidity/forecastPerDay;
    }
}
