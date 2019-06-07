package com.zoardgeocze.testehbsis.viewModel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.MainThread;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.City;
import com.zoardgeocze.testehbsis.model.ForecastClimateResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ForecastClimateViewModel extends Observable {

    public ObservableInt forecastRecycler;

    private Context context;
    private List<City> cities;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ForecastClimateViewModel(@NonNull Context context) {

        this.context = context;
        this.cities = new ArrayList<>();
        this.forecastRecycler = new ObservableInt(View.GONE);
        fetchCityList();
    }

    private void fetchCityList() {

        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .fetchForecast(524901, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForecastClimateResponse>() {
                               @Override
                               public void accept(ForecastClimateResponse forecastClimateResponse) throws Exception {
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
