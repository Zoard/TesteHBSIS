package com.zoardgeocze.testehbsis.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ItemWeatherForecastBinding;
import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {

    private List<Forecast> forecastList;
    private WeatherForecastViewModel weatherForecastViewModel;


    public WeatherForecastAdapter() {
        this.forecastList = new ArrayList<>();
    }

    public void setWeatherForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }

    @Override
    public WeatherForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemWeatherForecastBinding itemWeatherForecastBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_weather_forecast,
                parent,
                false);

        return new WeatherForecastViewHolder(itemWeatherForecastBinding);
    }

    @Override
    public void onBindViewHolder(WeatherForecastViewHolder holder, int position) {
        holder.bind(this.forecastList.get(position));
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }


    // public List<Forecast> getWeatherForecastList() { return this.forecastList; }
}
