package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class CurrentWeatherItemViewModel extends ViewModel {

    public ObservableField<String> cityName;
    public ObservableField<String> cityTemperature;

    public void init() {
        this.cityName = new ObservableField<>();
        this.cityTemperature = new ObservableField<>();
    }

    public void onClickItem(View view) {
        Log.i("ON_CLICK_ITEM", "onClickItem: ");
    }

    public void setCurrentWeather(CurrentWeatherResponse currentWeatherResponse) {
        this.cityName.set(currentWeatherResponse.name);
        this.cityTemperature.set(Double.toString(currentWeatherResponse.main.getTemp()));
    }
}
