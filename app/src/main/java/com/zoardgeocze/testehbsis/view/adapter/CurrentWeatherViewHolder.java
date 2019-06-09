package com.zoardgeocze.testehbsis.view.adapter;

import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.databinding.ActivityCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.databinding.ItemCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.viewModel.CurrentWeatherItemViewModel;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherViewHolder extends RecyclerView.ViewHolder {

    private final ItemCurrentWeatherBinding itemCurrentWeatherBinding;

    public CurrentWeatherViewHolder(ItemCurrentWeatherBinding itemCurrentWeatherBinding) {
        super(itemCurrentWeatherBinding.getRoot());
        this.itemCurrentWeatherBinding = itemCurrentWeatherBinding;
    }

    public void bindWeatherForecast(WeatherForecastResponse weatherForecast) {
        this.itemCurrentWeatherBinding.getCurrentWeatherItemViewModel().setWeatherForecast(weatherForecast);
    }

}
