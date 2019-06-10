package com.zoardgeocze.testehbsis.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.adapter.CurrentWeatherAdapter;
import com.zoardgeocze.testehbsis.view.adapter.WeatherForecastAdapter;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

import java.util.List;

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
        this.setForecastRecyclerView(this.activityWeatherForecastBinding.weatherForecastRecyclerView);
    }

    private void bind() {
        this.activityWeatherForecastBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_forecast);
        this.weatherForecastViewModel = ViewModelProviders.of(this).get(WeatherForecastViewModel.class);
        this.weatherForecastViewModel.init(getDataFromIntent());
        this.activityWeatherForecastBinding.setWeatherForecastViewModel(this.weatherForecastViewModel);
        this.activityWeatherForecastBinding.setLifecycleOwner(this);
        setLiveData();
    }

    private void setForecastRecyclerView(RecyclerView weatherForecastRecycler) {
        WeatherForecastAdapter weatherForecastAdapter = new WeatherForecastAdapter();
        weatherForecastRecycler.setAdapter(weatherForecastAdapter);
        weatherForecastRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLiveData() {
        this.weatherForecastViewModel.getWeatherForecastResponse().observe(this, this::setNewItemOnCurrentWeatherList);
    }

    private void setNewItemOnCurrentWeatherList(WeatherForecastResponse weatherForecastResponse) {
        WeatherForecastAdapter weatherForecastAdapter = (WeatherForecastAdapter) this.activityWeatherForecastBinding
                .weatherForecastRecyclerView
                .getAdapter();
        weatherForecastAdapter.setWeatherForecastList(weatherForecastResponse.getFiveDaysForecast());
    }

    private CurrentWeatherResponse getDataFromIntent() {
        Intent intent = getIntent();
        CurrentWeatherResponse currentWeatherResponse = (CurrentWeatherResponse) intent.getSerializableExtra(Constants.CITY);
        // Toast.makeText(this, currentWeatherResponse.name + " " + currentWeatherResponse.main.getTemp(), Toast.LENGTH_LONG).show();

        return currentWeatherResponse;
    }
}
