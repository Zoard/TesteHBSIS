package com.zoardgeocze.testehbsis.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityDisplayForecastClimateBinding;
import com.zoardgeocze.testehbsis.view.adapter.ForecastClimateAdapter;
import com.zoardgeocze.testehbsis.viewModel.ForecastClimateViewModel;

public class DisplayForecastClimateActivity extends AppCompatActivity {

    private ActivityDisplayForecastClimateBinding displayForecastClimateBinding;
    private ForecastClimateViewModel forecastClimateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bind();
        this.setForecastRecyclerView(this.displayForecastClimateBinding.displayForecastRecyclerView);
    }

    private void bind() {
        this.displayForecastClimateBinding = DataBindingUtil.setContentView(this, R.layout.activity_display_forecast_climate);
        this.forecastClimateViewModel = new ForecastClimateViewModel(this);
        this.displayForecastClimateBinding.setForecastClimateViewModel(this.forecastClimateViewModel);
    }

    private void setForecastRecyclerView(RecyclerView forecastRecycler) {
        ForecastClimateAdapter forecastClimateAdapter = new ForecastClimateAdapter();
        forecastRecycler.setAdapter(forecastClimateAdapter);
        forecastRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
