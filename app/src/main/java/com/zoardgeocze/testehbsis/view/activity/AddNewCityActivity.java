package com.zoardgeocze.testehbsis.view.activity;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.databinding.ActivityAddNewCityBinding;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.viewModel.AddNewCityViewModel;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddNewCityActivity extends AppCompatActivity {

    private ActivityAddNewCityBinding addNewCityBinding;
    private AddNewCityViewModel addNewCityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {
        this.addNewCityBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_city);
        this.addNewCityViewModel = ViewModelProviders.of(this).get(AddNewCityViewModel.class);
        this.addNewCityViewModel.init();
        this.addNewCityBinding.setAddNewCityViewModel(this.addNewCityViewModel);
        setLiveData();
    }

    private void setLiveData() {
        this.addNewCityViewModel.getCurrentWeatherResponse().observe(this, this::addOnCurrentWeatherList);
    }

    public void addOnCurrentWeatherList(CurrentWeatherResponse currentWeatherResponse) {
        Intent intent = getIntent();
        intent.putExtra(Constants.RESPONSE, currentWeatherResponse);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
