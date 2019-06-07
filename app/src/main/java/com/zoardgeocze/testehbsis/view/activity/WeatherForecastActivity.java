package com.zoardgeocze.testehbsis.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityWeatherForecastBinding;
import com.zoardgeocze.testehbsis.view.adapter.WeatherForecastAdapter;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

public class WeatherForecastActivity extends AppCompatActivity {

    private ActivityWeatherForecastBinding weatherForecastBinding;
    private WeatherForecastViewModel weatherForecastViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bind();
        this.setForecastRecyclerView(this.weatherForecastBinding.displayForecastRecyclerView);
    }

    private void bind() {
        this.weatherForecastBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_forecast);
        this.weatherForecastViewModel = new WeatherForecastViewModel(this);
        this.weatherForecastBinding.setWeatherForecastViewModel(this.weatherForecastViewModel);
    }

    private void setForecastRecyclerView(RecyclerView forecastRecycler) {
        WeatherForecastAdapter weatherForecastAdapter = new WeatherForecastAdapter();
        forecastRecycler.setAdapter(weatherForecastAdapter);
        forecastRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
