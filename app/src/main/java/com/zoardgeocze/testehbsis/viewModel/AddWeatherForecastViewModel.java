package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.WeatherForecastItem;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;


/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddWeatherForecastViewModel extends ViewModel {

    public ObservableField<String> cityName;
    public ObservableInt progressBar;
    public ObservableInt viewsVisibility;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<WeatherForecastResponse> weatherForecastResponse = new MutableLiveData<>();

    /*public AddWeatherForecastViewModel(@NonNull Context context) {
        // this.context = context;
        this.weatherForecast = new WeatherForecastResponse();
        this.cityName = new ObservableField<>();
        this.progressBar = new ObservableInt(View.GONE);
        this.viewsVisibility = new ObservableInt(View.VISIBLE);
    }*/

    public void init() {
        this.cityName = new ObservableField<>();
        this.progressBar = new ObservableInt(View.GONE);
        this.viewsVisibility = new ObservableInt(View.VISIBLE);
    }

    public void onClickFetchWeatherForecast(View view) {
        this.viewsVisibility.set(View.GONE);
        this.progressBar.set(View.VISIBLE);
        getForecastByCityName();
    }

    public MutableLiveData<WeatherForecastResponse> getNewWeatherForecast() {
        return this.weatherForecastResponse;
    }

    /*private void getForecastByCityName() {

        Log.i("FETCH_City_Name: ", cityName.get());

        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .getForecastByCityName(cityName.get(), Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResponse>() {
                    @Override
                    public void accept(WeatherForecastResponse weatherForecastResponse) throws Exception {
                        Log.i("FETCH_City_Name: ", weatherForecastResponse.city.getName());
                        Log.i("FETCH_List_Size: ", Integer.toString(weatherForecastResponse.list.size()));
                        viewsVisibility.set(View.VISIBLE);
                        progressBar.set(View.GONE);
                        weatherForecast = weatherForecastResponse;
                        weatherForecast.setNewItem();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        viewsVisibility.set(View.VISIBLE);
                        progressBar.set(View.GONE);
                        Log.i("FETCH_ERROR: ", "Not worked");
                    }
                });

        weatherForecast.setNewItem();

        compositeDisposable.add(disposable);
    }*/

    private void getForecastByCityName() {

        Log.i("FETCH_City_Name: ", cityName.get());

        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .getForecastByCityName(cityName.get(), Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> weatherForecastResponse.setValue(result));

        compositeDisposable.add(disposable);

    }



}