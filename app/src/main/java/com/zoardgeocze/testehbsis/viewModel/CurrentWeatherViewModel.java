package com.zoardgeocze.testehbsis.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZoardGeocze on 06/06/19.
 */

public class CurrentWeatherViewModel extends ViewModel {

    public ObservableInt currentWeatherRecycler;

    private List<WeatherForecastResponse> weatherForecastList;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<WeatherForecastResponse>> weatherForecastResponseList = new MutableLiveData<>();
    private MutableLiveData<View> onClick = new MutableLiveData<>();

    public void init() {
        this.weatherForecastList = new ArrayList<>();
        this.currentWeatherRecycler = new ObservableInt(View.VISIBLE);
        fetchWeatherForecastList();
    }

    public MutableLiveData<List<WeatherForecastResponse>> getWeatherForecastResponseList() {
        return this.weatherForecastResponseList;
    }

    public MutableLiveData<View> getOnClick() { return this.onClick; }

    public void onClickAddNewCity(View view) { this.onClick.postValue(view); }

    private void fetchWeatherForecastList() {
        //TODO: Fetch the cities persisted when open the app
        /*Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .fetchForecast(524901, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResponse>() {
                           @Override
                           public void accept(WeatherForecastResponse forecastClimateResponse) throws Exception {
                               Log.i("FETCH_City_Name: ", forecastClimateResponse.city.getName());
                               Log.i("FETCH_List_Size: ", Integer.toString(forecastClimateResponse.list.size()));

                               updateWeatherForecastList();

                           }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {

                               }
                           });


        compositeDisposable.add(disposable);*/
    }

    private void updateWeatherForecastList() {
        //TODO: Update here the WeatherMain Forecast List

    }

    @Override
    protected void onCleared() { compositeDisposable.clear(); }

}
