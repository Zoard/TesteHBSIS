package com.zoardgeocze.testehbsis.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastItem {

    public City city = new City();
    public List<Forecast> list = new ArrayList<>();

    public WeatherForecastItem(City city, List<Forecast> list) {
        this.city = city;
        this.list = list;
    }
}
