package com.zoardgeocze.testehbsis.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zoardgeocze.testehbsis.databinding.ItemWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {

    private ItemWeatherForecastBinding itemWeatherForecastBinding;

    public WeatherForecastViewHolder(ItemWeatherForecastBinding itemWeatherForecastBinding) {
        super(itemWeatherForecastBinding.itemWeatherForecast);
        this.itemWeatherForecastBinding = itemWeatherForecastBinding;
    }

    public void bindWeatherForecast(WeatherForecastResponse weatherForecast) {
        this.itemWeatherForecastBinding.getItemWeatherForecastViewModel().setWeatherForecast(weatherForecast);
    }

}
