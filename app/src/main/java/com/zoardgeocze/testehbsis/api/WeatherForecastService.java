package com.zoardgeocze.testehbsis.api;

import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherForecastService {

    @GET("forecast")
    Observable<WeatherForecastResponse> fetchForecast(@Query("id") long id, @Query("appid") String appid);

    @GET("forecast")
    Observable<WeatherForecastResponse> getForecastByCityName(@Query("q") long cityName,
                                                              @Query("units") String units,
                                                              @Query("appid") String appid);

}
