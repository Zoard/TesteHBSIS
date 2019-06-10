package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.activity.WeatherForecastActivity;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class CurrentWeatherItemViewModel extends ViewModel {

    public ObservableField<String> cityName;
    public ObservableField<String> cityTemperature;
    private CurrentWeatherResponse currentWeatherResponse;
    private Context context;

    public void init(Context context) {
        this.context = context;
        this.cityName = new ObservableField<>();
        this.cityTemperature = new ObservableField<>();
    }

    public void onClickItem(View view) {
        Log.i("ON_CLICK_ITEM", "onClickItem: ");
        Intent intent = new Intent(this.context, WeatherForecastActivity.class);
        intent.putExtra(Constants.CITY, this.currentWeatherResponse);
        this.context.startActivity(intent);
    }

    public void setCurrentWeather(CurrentWeatherResponse currentWeatherResponse) {
        this.currentWeatherResponse = currentWeatherResponse;
        this.cityName.set(currentWeatherResponse.name);
        this.cityTemperature.set(Double.toString(currentWeatherResponse.main.getTemp()));
    }
}
