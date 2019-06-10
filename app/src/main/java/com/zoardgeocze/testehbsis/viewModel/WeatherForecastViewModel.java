package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private WeatherForecastResponse weatherForecastResponse;
    private WeatherForecastAdapter weatherForecastAdapter;

    public ObservableInt progressBar;
    public ObservableInt weatherForecastRecycler;
    public ObservableField<String> cityName;
    public ObservableField<String> cityTemperature;
    public ObservableField<String> cityTemperatureMax;
    public ObservableField<String> cityTemperatureMin;
    public ObservableField<String> cityHumidity;
    public ObservableField<String> cityPressure;
    public ObservableField<String> weatherDate;


    public void init(CurrentWeatherResponse currentWeatherResponse) {
        this.currentWeatherResponse = new CurrentWeatherResponse();
        this.weatherForecastResponse = new WeatherForecastResponse();
        this.currentWeatherResponse = currentWeatherResponse;
        this.weatherForecastAdapter = new WeatherForecastAdapter(R.layout.item_weather_forecast, this);
        setLayoutComponents();
        fetchWeatherForecastList();
    }

    private void setLayoutComponents() {
        this.progressBar = new ObservableInt(View.VISIBLE);
        this.weatherForecastRecycler = new ObservableInt(View.GONE);
        this.cityName = new ObservableField<>();
        this.cityTemperature = new ObservableField<>();
        this.cityTemperatureMax = new ObservableField<>();
        this.cityTemperatureMin = new ObservableField<>();
        this.cityHumidity = new ObservableField<>();
        this.cityPressure = new ObservableField<>();
        this.weatherDate = new ObservableField<>();
    }

    public WeatherForecastAdapter getAdapter() {
        return this.weatherForecastAdapter;
    }

    public void setWeaterForecastInAdapter(List<Forecast> forecastList) {
        this.weatherForecastAdapter.setWeatherForecastList(forecastList);
        this.weatherForecastAdapter.notifyDataSetChanged();
    }

    private void fetchWeatherForecastList() {
        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .fetchWeatherForecast(this.currentWeatherResponse.id, Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                            weatherForecastResponse = result;
                            progressBar.set(View.GONE);
                            setWeaterForecastInAdapter(weatherForecastResponse.getFiveDaysForecast());
                            weatherForecastRecycler.set(View.VISIBLE);
                        },
                        ((throwable) -> {
                            progressBar.set(View.GONE);
                        }));


        compositeDisposable.add(disposable);
    }

    public void fetchWeatherForecastItemImage(Integer position) {
        //TODO: Fetch Image Here
    }

    public void onClickItem(Integer position) {

    }

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCleared() { this.compositeDisposable.clear(); }
}
