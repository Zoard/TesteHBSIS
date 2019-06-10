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

// Seguindo o SOLID. Vantagem: Menos delegações para um único ViewModel. Desvantagem: Memory Leak.

public class CurrentWeatherItemViewModel extends ViewModel {

    private CurrentWeatherResponse currentWeatherResponse;
    private Context context;

    public ObservableField<String> cityName;
    public ObservableField<String> cityTemperature;
    public ObservableField<String> cityTemperatureMax;
    public ObservableField<String> cityTemperatureMin;
    public ObservableField<String> cityHumidity;
    public ObservableField<String> cityPressure;
    public ObservableField<String> weatherDate;

    public void init(Context context) {
        this.context = context;
        setLayoutComponents();
    }

    public void setLayoutComponents() {
        this.cityName = new ObservableField<>();
        this.cityTemperature = new ObservableField<>();
        this.cityTemperatureMax = new ObservableField<>();
        this.cityTemperatureMin = new ObservableField<>();
        this.cityHumidity = new ObservableField<>();
        this.cityPressure = new ObservableField<>();
        this.weatherDate = new ObservableField<>();
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
        this.cityTemperature.set(currentWeatherResponse.main.getTempView());
        this.cityTemperatureMax.set(currentWeatherResponse.main.getTempMaxView());
        this.cityTemperatureMin.set(currentWeatherResponse.main.getTempMinView());
        this.cityHumidity.set(currentWeatherResponse.main.getHumidityView());
        this.cityPressure.set(currentWeatherResponse.main.getPressureView());
        this.weatherDate.set(currentWeatherResponse.getDateView());
    }
}
