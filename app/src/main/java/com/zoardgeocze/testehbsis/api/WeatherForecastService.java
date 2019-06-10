package com.zoardgeocze.testehbsis.api;

import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public interface WeatherForecastService {

    @GET("group")
    Observable<WeatherForecastResponse> fetchCurrentWeatherList(@Query("id") String id,
                                                                @Query("units") String units,
                                                                @Query("appid") String appid);

    @GET("weather")
    Observable<CurrentWeatherResponse> getCurrentWeatherByCityName(@Query("q") String cityName,
                                                                   @Query("units") String units,
                                                                   @Query("appid") String appid);

    @GET("forecast")
    Observable<WeatherForecastResponse> fetchWeatherForecast(@Query("id") String id,
                                                             @Query("units") String units,
                                                             @Query("appid") String appid);

}
