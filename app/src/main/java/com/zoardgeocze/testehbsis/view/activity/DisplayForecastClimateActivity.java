package com.zoardgeocze.testehbsis.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.zoardgeocze.testehbsis.R;

public class DisplayForecastClimateActivity extends AppCompatActivity {

    private RecyclerView displayForecastRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_forecast_climate);
    }
}
