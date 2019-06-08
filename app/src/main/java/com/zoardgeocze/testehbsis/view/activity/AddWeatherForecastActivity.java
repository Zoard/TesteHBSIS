package com.zoardgeocze.testehbsis.view.activity;

import android.app.IntentService;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityAddWeatherForecastBinding;
import com.zoardgeocze.testehbsis.viewModel.AddWeatherForecastViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddWeatherForecastActivity extends AppCompatActivity implements Observer {

    private ActivityAddWeatherForecastBinding addWeatherForecastBinding;
    private AddWeatherForecastViewModel addWeatherForecastViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
        setObserver(this.addWeatherForecastViewModel);
    }

    private void bind() {
        this.addWeatherForecastBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_weather_forecast);
        this.addWeatherForecastViewModel = new AddWeatherForecastViewModel(this);
        this.addWeatherForecastBinding.setAddWeatherForecastViewModel(this.addWeatherForecastViewModel);
    }

    private void setObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof AddWeatherForecastViewModel) {

        }
    }
}
