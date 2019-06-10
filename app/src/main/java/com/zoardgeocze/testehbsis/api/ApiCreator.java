package com.zoardgeocze.testehbsis.api;

import com.zoardgeocze.testehbsis.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class ApiCreator {

    private final Retrofit retrofit;

    public ApiCreator() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        this.retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build();

    }

    public WeatherForecastService forecastClimateService() {return this.retrofit.create(WeatherForecastService.class);}

}
