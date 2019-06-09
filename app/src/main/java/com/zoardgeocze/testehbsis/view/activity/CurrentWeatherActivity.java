package com.zoardgeocze.testehbsis.view.activity;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityCurrentWeatherBinding;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.adapter.CurrentWeatherAdapter;
import com.zoardgeocze.testehbsis.viewModel.CurrentWeatherViewModel;

import java.util.List;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherActivity extends AppCompatActivity {

    private ActivityCurrentWeatherBinding currentWeatherBinding;
    private CurrentWeatherViewModel currentWeatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bind();
        this.setForecastRecyclerView(this.currentWeatherBinding.currentWeatherRecyclerView);
    }

    private void bind() {
        this.currentWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_current_weather);
        this.currentWeatherViewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel.class);
        this.currentWeatherViewModel.init();
        this.currentWeatherBinding.setCurrentWeatherViewModel(this.currentWeatherViewModel);
        setLiveData();
    }

    private void setForecastRecyclerView(RecyclerView currentWeatherRecycler) {
        CurrentWeatherAdapter currentWeatherAdapter = new CurrentWeatherAdapter();
        currentWeatherRecycler.setAdapter(currentWeatherAdapter);
        currentWeatherRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setLiveData() {
        this.currentWeatherViewModel
                .getWeatherForecastResponseList()
                .observe(this, this::updateItemOnWeatherForecastList);
    }

    public void updateItemOnWeatherForecastList(List<WeatherForecastResponse> weatherForecastResponseList) {
        CurrentWeatherAdapter currentWeatherAdapter = (CurrentWeatherAdapter) this.currentWeatherBinding
                .currentWeatherRecyclerView
                .getAdapter();
        currentWeatherAdapter.setCurrentWeatherList(weatherForecastResponseList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == Constants.ADD_FORECAST) {
            Log.i("ON_ACTIVITY_RESULT", "Recebeu o resultado...");
        }
    }
}
