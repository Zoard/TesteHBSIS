package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.activity.WeatherForecastActivity;

public class WeatherForecastItemViewModel extends ViewModel {

    private Forecast forecast;
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

    /*public void onClickItem(View view) {
        Log.i("ON_CLICK_ITEM", "onClickItem: ");
        Intent intent = new Intent(this.context, WeatherForecastActivity.class);
        intent.putExtra(Constants.CITY, this.currentWeatherResponse);
        this.context.startActivity(intent);
    }*/

    public void setCurrentWeather(Forecast forecast) {
        //this.cityName.set(forecast.name);
        this.cityTemperature.set(forecast.getMain().getTempView());
        this.cityTemperatureMax.set(forecast.getMain().getTempMaxView());
        this.cityTemperatureMin.set(forecast.getMain().getTempMinView());
        this.cityHumidity.set(forecast.getMain().getHumidityView());
        this.cityPressure.set(forecast.getMain().getPressureView());
        this.weatherDate.set(forecast.getDateView());
    }

}
