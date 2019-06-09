package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class CurrentWeatherItemViewModel extends ViewModel {

    private WeatherForecastResponse weatherForecast;
    public ObservableField<String> cityName;
    public ObservableField<String> cityTemperature;

    public void init() {
        this.weatherForecast = new WeatherForecastResponse();
        this.cityName = new ObservableField<>();
        this.cityTemperature = new ObservableField<>();
    }

    public void onClickItem(View view) {
        //TODO: Go to Details Activity
    }

    public void setWeatherForecast(WeatherForecastResponse weatherForecast) {
        this.weatherForecast = weatherForecast;
        this.cityName.set(weatherForecast.city.getName());
        this.cityTemperature.set(Double.toString(weatherForecast.list.get(0).getMain().getTemp()));
    }
}
