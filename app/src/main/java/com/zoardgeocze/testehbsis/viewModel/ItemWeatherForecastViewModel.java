package com.zoardgeocze.testehbsis.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class ItemWeatherForecastViewModel extends BaseObservable {

    private WeatherForecastResponse weatherForecast;
    private Context context;

    public ItemWeatherForecastViewModel(WeatherForecastResponse weatherForecast, Context context) {
        this.weatherForecast = weatherForecast;
        this.context = context;
    }

    public void onClickItem(View view) {
        //TODO: Go to Details Activity
    }

    public void setWeatherForecast(WeatherForecastResponse weatherForecast) {
        this.weatherForecast = weatherForecast;
        notifyChange();
    }
}
