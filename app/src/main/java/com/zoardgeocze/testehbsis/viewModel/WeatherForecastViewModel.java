package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.zoardgeocze.testehbsis.R;
import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.model.Forecast;
import com.zoardgeocze.testehbsis.model.WeatherForecastResponse;
import com.zoardgeocze.testehbsis.utils.Constants;
import com.zoardgeocze.testehbsis.view.adapter.WeatherForecastAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZoardGeocze on 09/06/19.
 */

// Seguindo o Recomendado pelo Google. Vantagem: Não existe preocupação com Memory Leak. Desvantagem: ViewModel pode delegar muito.


public class WeatherForecastViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private CurrentWeatherResponse currentWeatherResponse;
    private MutableLiveData<WeatherForecastResponse> weatherForecastResponse = new MutableLiveData<>();

    public ObservableInt progressBar;
    public ObservableInt weatherForecastRecycler;
    public ObservableField<String> cityName;


    public void init(CurrentWeatherResponse currentWeatherResponse) {
        this.currentWeatherResponse = new CurrentWeatherResponse();
        this.currentWeatherResponse = currentWeatherResponse;
        setLayoutComponents();
        fetchWeatherForecastList();
    }

    private void setLayoutComponents() {
        this.progressBar = new ObservableInt(View.VISIBLE);
        this.weatherForecastRecycler = new ObservableInt(View.GONE);
        this.cityName = new ObservableField<>();
    }

    public MutableLiveData<WeatherForecastResponse> getWeatherForecastResponse() { return this.weatherForecastResponse; }


    private void fetchWeatherForecastList() {
        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .fetchWeatherForecast(String.valueOf(this.currentWeatherResponse.id), Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            this.weatherForecastResponse.setValue(result);
                            progressBar.set(View.GONE);
                            weatherForecastRecycler.set(View.VISIBLE);
                        },
                        (throwable -> {
                            progressBar.set(View.GONE);
                        }));


        compositeDisposable.add(disposable);
    }

    /*public void fetchWeatherForecastItemImage(Integer position) {
        //TODO: Fetch Image Here
        List<Forecast> forecastList = getAdapter().getWeatherForecastList();
        Forecast forecast = forecastList.get(position);
    }*/


    @Override
    protected void onCleared() { this.compositeDisposable.clear(); }
}
