package com.zoardgeocze.testehbsis.api;

import com.zoardgeocze.testehbsis.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class ApiCreator {

    private final Retrofit retrofit;

    public ApiCreator() {

        this.retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public WeatherForecastService forecastClimateService() {return this.retrofit.create(WeatherForecastService.class);}

}
