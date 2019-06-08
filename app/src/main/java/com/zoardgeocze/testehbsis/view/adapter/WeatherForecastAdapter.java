package com.zoardgeocze.testehbsis.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ItemWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {

    private List<WeatherForecastResponse> weatherForecastList = new ArrayList<>();

    @Override
    public WeatherForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWeatherForecastBinding itemWeatherForecastBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_weather_forecast,
                        parent,
                        false);
        return new WeatherForecastViewHolder(itemWeatherForecastBinding);
    }

    @Override
    public void onBindViewHolder(WeatherForecastViewHolder holder, int position) {
        holder.bindWeatherForecast(this.weatherForecastList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherForecastList.size();
    }

    public void setWeatherForecastList(List<WeatherForecastResponse> weatherForecastList) {
        this.weatherForecastList = weatherForecastList;
        this.notifyDataSetChanged();
    }
}
