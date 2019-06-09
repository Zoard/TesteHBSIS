package com.zoardgeocze.testehbsis.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ItemCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherAdapter extends RecyclerView.Adapter<CurrentWeatherViewHolder> {

    private List<WeatherForecastResponse> currentWeatherList = new ArrayList<>();

    @Override
    public CurrentWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCurrentWeatherBinding itemCurrentWeatherBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_current_weather,
                        parent,
                        false);
        return new CurrentWeatherViewHolder(itemCurrentWeatherBinding);
    }

    @Override
    public void onBindViewHolder(CurrentWeatherViewHolder holder, int position) {
        holder.bindWeatherForecast(this.currentWeatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentWeatherList.size();
    }

    public void setCurrentWeatherList(List<WeatherForecastResponse> currentWeatherList) {
        this.currentWeatherList = currentWeatherList;
        this.notifyDataSetChanged();
    }
}
