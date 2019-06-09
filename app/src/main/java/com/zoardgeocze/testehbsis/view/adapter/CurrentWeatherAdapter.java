package com.zoardgeocze.testehbsis.view.adapter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ItemCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.viewModel.CurrentWeatherItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherAdapter extends RecyclerView.Adapter<CurrentWeatherViewHolder> {

    private List<WeatherForecastResponse> currentWeatherList = new ArrayList<>();
    private CurrentWeatherItemViewModel currentWeatherItemViewModel;

    @Override
    public CurrentWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.currentWeatherItemViewModel = ViewModelProviders.of((FragmentActivity) parent.getContext()).get(CurrentWeatherItemViewModel.class);
        this.currentWeatherItemViewModel.init();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCurrentWeatherBinding itemCurrentWeatherBinding = DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.item_current_weather,
                        parent,
                        false);
        itemCurrentWeatherBinding.setCurrentWeatherItemViewModel(currentWeatherItemViewModel);
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

    public void setCurrentWeatherList(WeatherForecastResponse weatherForecastResponse) {
        this.currentWeatherList.add(weatherForecastResponse);
        Log.i("CURRENT_WEATHER_ADAPTER", "setCurrentWeatherList: ");
        this.notifyDataSetChanged();
    }
}
