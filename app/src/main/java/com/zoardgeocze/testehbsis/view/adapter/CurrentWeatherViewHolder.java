package com.zoardgeocze.testehbsis.view.adapter;

import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.databinding.ItemCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.viewModel.CurrentWeatherItemViewModel;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherViewHolder extends RecyclerView.ViewHolder {

    private ItemCurrentWeatherBinding itemCurrentWeatherBinding;
    private CurrentWeatherItemViewModel currentWeatherItemViewModel;

    public CurrentWeatherViewHolder(ItemCurrentWeatherBinding itemCurrentWeatherBinding) {
        super(itemCurrentWeatherBinding.currentWeatherItem);
        this.itemCurrentWeatherBinding = itemCurrentWeatherBinding;
        this.currentWeatherItemViewModel = new CurrentWeatherItemViewModel();
        this.currentWeatherItemViewModel.init(itemView.getContext());
        this.itemCurrentWeatherBinding.setCurrentWeatherItemViewModel(this.currentWeatherItemViewModel);
    }

    public void bindCurrentWeather(CurrentWeatherResponse currentWeatherResponse) {
        this.itemCurrentWeatherBinding.getCurrentWeatherItemViewModel().setCurrentWeather(currentWeatherResponse);
    }

}
