package com.zoardgeocze.testehbsis.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityWeatherForecastBinding;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.adapter.WeatherForecastAdapter;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class WeatherForecastActivity extends AppCompatActivity implements Observer {

    private ActivityWeatherForecastBinding weatherForecastBinding;
    private WeatherForecastViewModel weatherForecastViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bind();
        this.setForecastRecyclerView(this.weatherForecastBinding.displayForecastRecyclerView);
        this.setObserver(this.weatherForecastViewModel);
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

    //Registra a View para ser notificado pelo ViewModel
    private void setObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof WeatherForecastViewModel) {
            WeatherForecastAdapter weatherForecastAdapter = (WeatherForecastAdapter) this.weatherForecastBinding
                    .displayForecastRecyclerView
                    .getAdapter();
            WeatherForecastViewModel weatherForecastViewModel = (WeatherForecastViewModel) o;
            weatherForecastAdapter.setWeatherForecastList(weatherForecastViewModel.getForecastResponseList());
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == this.RESULT_OK && requestCode == Constants.ADD_FORECAST) {
            // TODO: Receive Activity Result
        }
    }

    //Realiza um Dispose para evitar Memory Leak
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.weatherForecastViewModel.dispose();
    }
}
