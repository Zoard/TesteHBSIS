package com.zoardgeocze.testehbsis.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.zoardgeocze.testehbsis.api.ApiCreator;
import com.zoardgeocze.testehbsis.model.CurrentWeatherResponse;
import com.zoardgeocze.testehbsis.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ZoardGeocze on 07/06/19.
 */

public class AddNewCityViewModel extends ViewModel {

    public ObservableField<String> cityName;
    public ObservableInt progressBar;
    public ObservableInt viewsVisibility;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<CurrentWeatherResponse> currentWeatherResponse = new MutableLiveData<>();

    public void init() {
        this.cityName = new ObservableField<>();
        this.progressBar = new ObservableInt(View.GONE);
        this.viewsVisibility = new ObservableInt(View.VISIBLE);
    }

    public void onClickFetchWeatherForecast(View view) {
        this.viewsVisibility.set(View.GONE);
        this.progressBar.set(View.VISIBLE);
        getCurrentWeatherByCityName();
    }

    public MutableLiveData<CurrentWeatherResponse> getCurrentWeatherResponse() {
        return this.currentWeatherResponse;
    }

    private void getCurrentWeatherByCityName() {

        Disposable disposable = new ApiCreator()
                .forecastClimateService()
                .getCurrentWeatherByCityName(cityName.get(), Constants.METRIC_UNIT, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> currentWeatherResponse.setValue(result),
                        throwable -> {
                            progressBar.set(View.GONE);
                            viewsVisibility.set(View.VISIBLE);
                        });

        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() { compositeDisposable.clear(); }
}