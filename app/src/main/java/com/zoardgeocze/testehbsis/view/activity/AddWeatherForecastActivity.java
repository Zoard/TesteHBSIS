package com.zoardgeocze.testehbsis.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityAddWeatherForecastBinding;
import com.zoardgeocze.testehbsis.viewModel.AddWeatherForecastViewModel;

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
        this.addWeatherForecastViewModel = new AddWeatherForecastViewModel(this);
        this.addWeatherForecastBinding.setAddWeatherForecastViewModel(this.addWeatherForecastViewModel);
    }
}
