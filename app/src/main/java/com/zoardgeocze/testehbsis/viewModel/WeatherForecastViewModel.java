package com.zoardgeocze.testehbsis.viewModel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.City;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherForecastViewModel extends Observable {

    public ObservableInt forecastRecycler;

    private Context context;
    private List<City> cities;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public WeatherForecastViewModel(@NonNull Context context) {

        this.context = context;
        this.cities = new ArrayList<>();
        this.forecastRecycler = new ObservableInt(View.GONE);
        fetchCityList();
    }

    public void onClickAddForecast(View view) {
        //TODO: Opens Add Forecast Activity
        Log.i("Click", "onClickAddForecast: CLICOU");

    }

    private void fetchCityList() {
        //TODO: Fetch the cities persisted when open the app
        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .fetchForecast(524901, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResponse>() {
                               @Override
                               public void accept(WeatherForecastResponse forecastClimateResponse) throws Exception {
                                   Log.i("FETCH: ", forecastClimateResponse.city.getName());
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                               }
                           });


        compositeDisposable.add(disposable);
    }
}
