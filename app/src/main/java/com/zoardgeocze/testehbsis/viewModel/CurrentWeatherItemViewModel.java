package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.view.View;

import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class CurrentWeatherItemViewModel extends ViewModel {

    private WeatherForecastResponse weatherForecast;
    private Context context;

    public CurrentWeatherItemViewModel(WeatherForecastResponse weatherForecast, Context context) {
        this.weatherForecast = weatherForecast;
        this.context = context;
    }

    public void onClickItem(View view) {
        //TODO: Go to Details Activity
    }

    public void setWeatherForecast(WeatherForecastResponse weatherForecast) {
        this.weatherForecast = weatherForecast;
        //notifyChange();
    }
}
