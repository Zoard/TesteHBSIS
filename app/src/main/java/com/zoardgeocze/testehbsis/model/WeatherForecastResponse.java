package com.zoardgeocze.testehbsis.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse implements Serializable {

    public City city;
    public List<Forecast> list = new ArrayList<>();

    public List<Forecast> getFiveDaysForecast() {

        List<Forecast> forecasts = new ArrayList<>();
        double temp = 0.0, tempMax = 0.0, tempMin = 0.0, pressure = 0.0, humidity = 0.0;
        int forecastPerDay = 8;

        for(int i = 0; i < this.list.size(); i++) {

            if (i % forecastPerDay == 0) {

                if (i != 0) {
                    int lastIndex = forecasts.size() - 1;
                    forecasts.get(lastIndex).getMain().setAverage(temp, tempMax, tempMin, pressure, humidity);
                }

                forecasts.add(this.list.get(i));
                temp = 0.0; tempMax = 0.0; tempMin = 0.0; humidity = 0.0; pressure = 0.0;

            }

            temp += this.list.get(i).getMain().getTemp();
            tempMax += this.list.get(i).getMain().getTemp_max();
            tempMin += this.list.get(i).getMain().getTemp_min();
            humidity += this.list.get(i).getMain().getHumidity();
            pressure += this.list.get(i).getMain().getPressure();

        }

        return forecasts;
    }

}
