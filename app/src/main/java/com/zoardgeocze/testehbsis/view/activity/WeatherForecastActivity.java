package com.zoardgeocze.testehbsis.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

/**
 * Created by ZoardGeocze on 09/06/19.
 */


public class WeatherForecastActivity extends AppCompatActivity {

    private ActivityWeatherForecastBinding activityWeatherForecastBinding;
    private WeatherForecastViewModel weatherForecastViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
        getDataFromIntent();
    }

    private void bind() {
        this.activityWeatherForecastBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_forecast);
        this.weatherForecastViewModel = ViewModelProviders.of(this).get(WeatherForecastViewModel.class);
        this.weatherForecastViewModel.init();
        this.activityWeatherForecastBinding.setWeatherForecastViewModel(this.weatherForecastViewModel);
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        CurrentWeatherResponse currentWeatherResponse = (CurrentWeatherResponse) intent.getSerializableExtra(Constants.CITY);
        Toast.makeText(this, currentWeatherResponse.name + " " + currentWeatherResponse.main.getTemp(), Toast.LENGTH_LONG).show();
    }
}
