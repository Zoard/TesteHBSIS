package com.zoardgeocze.testehbsis.view.adapter;

import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.databinding.ItemWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastItemViewModel;

public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {

    private ItemWeatherForecastBinding itemWeatherForecastBinding;
    private WeatherForecastItemViewModel weatherForecastItemViewModel;

    public WeatherForecastViewHolder(ItemWeatherForecastBinding itemWeatherForecastBinding) {
        super(itemWeatherForecastBinding.weatherForecastItem);
        this.itemWeatherForecastBinding = itemWeatherForecastBinding;
        this.weatherForecastItemViewModel = new WeatherForecastItemViewModel();
        this.weatherForecastItemViewModel.init();
        this.itemWeatherForecastBinding.setWeatherForecastItemViewModel(this.weatherForecastItemViewModel);
    }

    public void bind(Forecast forecast) {
        this.itemWeatherForecastBinding.getWeatherForecastItemViewModel().setCurrentWeather(forecast);
    }
}
