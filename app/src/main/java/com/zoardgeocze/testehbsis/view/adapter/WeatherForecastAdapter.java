package com.zoardgeocze.testehbsis.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {

    private List<Forecast> forecastList;
    private int layoutId;
    private WeatherForecastViewModel weatherForecastViewModel;

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    public WeatherForecastAdapter(@LayoutRes int layoutId, WeatherForecastViewModel weatherForecastViewModel) {
        this.forecastList = new ArrayList<>();
        this.layoutId = layoutId;
        this.weatherForecastViewModel = weatherForecastViewModel;
    }

    @Override
    public WeatherForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new WeatherForecastViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(WeatherForecastViewHolder holder, int position) {
        holder.bind(this.weatherForecastViewModel, position);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    @Override
    public int getItemViewType(int position) { return getLayoutIdForPosition(position); }

    public void setWeatherForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }
}
