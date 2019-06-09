package com.zoardgeocze.testehbsis.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse {

    public City city;
    public List<Forecast> list = new ArrayList<>();

    /*public MutableLiveData<WeatherForecastItem> item = new MutableLiveData<>();

    public WeatherForecastResponse() {
        city = new City();
    }

    public void setNewItem() {
        this.item.setValue(new WeatherForecastItem(this.city, this.list));
    }
    */


}
