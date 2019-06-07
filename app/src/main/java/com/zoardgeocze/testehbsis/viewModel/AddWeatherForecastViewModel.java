package com.zoardgeocze.testehbsis.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddWeatherForecastViewModel extends Observable {

    public ObservableField<String> cityName;
    public ObservableInt progressBar;
    public ObservableInt viewsVisibility;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Context context;

    public AddWeatherForecastViewModel(@NonNull Context context) {
        this.context = context;
        this.cityName = new ObservableField<>();
        this.progressBar = new ObservableInt(View.GONE);
        this.viewsVisibility = new ObservableInt(View.VISIBLE);
    }

    public void onClickFetchWeatherForecast(View view) {
        this.viewsVisibility.set(View.GONE);
        this.progressBar.set(View.VISIBLE);
        getForecastByCityName();
    }

    private void getForecastByCityName() {

        Log.i("FETCH_City_Name: ", cityName.get());

        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .getForecastByCityName(cityName.get(), Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResponse>() {
                    @Override
                    public void accept(WeatherForecastResponse forecastClimateResponse) throws Exception {
                        Log.i("FETCH_City_Name: ", forecastClimateResponse.city.getName());
                        Log.i("FETCH_List_Size: ", Integer.toString(forecastClimateResponse.list.size()));
                        viewsVisibility.set(View.VISIBLE);
                        progressBar.set(View.GONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        viewsVisibility.set(View.VISIBLE);
                        progressBar.set(View.GONE);
                        Log.i("FETCH_ERROR: ", "Not worked");
                    }
                });

        compositeDisposable.add(disposable);
    }


}