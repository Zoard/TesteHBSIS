package com.zoardgeocze.testehbsis.view.activity;

import android.app.IntentService;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityAddWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastItem;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.viewModel.AddWeatherForecastViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddWeatherForecastActivity extends AppCompatActivity {

    private ActivityAddWeatherForecastBinding addWeatherForecastBinding;
    private AddWeatherForecastViewModel addWeatherForecastViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {
        this.addWeatherForecastBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_weather_forecast);
        this.addWeatherForecastViewModel = ViewModelProviders.of(this).get(AddWeatherForecastViewModel.class);
        this.addWeatherForecastViewModel.init();
        this.addWeatherForecastBinding.setAddWeatherForecastViewModel(this.addWeatherForecastViewModel);
        setLiveData();
    }

    private void setLiveData() {
        this.addWeatherForecastViewModel.getNewWeatherForecast().observe(this, this::addOnWeatherForecastList);
    }

    public void addOnWeatherForecastList(WeatherForecastResponse weatherForecastResponse) {
        Log.i("RESPONSE", "Recebeu!! ");
    }
}
