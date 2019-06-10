package com.zoardgeocze.testehbsis.view.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.BR;
import com.zoardgeocze.testehbsis.viewModel.WeatherForecastViewModel;

public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding viewDataBinding;

    public WeatherForecastViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
    }

    public void bind(WeatherForecastViewModel weatherForecastViewModel, Integer position) {
        weatherForecastViewModel.fetchWeatherForecastItemImage(position);
        this.viewDataBinding.setVariable(BR.weatherForecastViewModel, weatherForecastViewModel);
        this.viewDataBinding.setVariable(BR.position, position);
    }
}
