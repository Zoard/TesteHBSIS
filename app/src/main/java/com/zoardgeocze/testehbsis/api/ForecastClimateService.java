package com.zoardgeocze.testehbsis.api;

import com.zoardgeocze.testehbsis.model.ForecastClimateResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastClimateService {

    @GET("forecast")
    Observable<ForecastClimateResponse> fetchForecast(@Query("id") long id, @Query("appid") String appid);

}
