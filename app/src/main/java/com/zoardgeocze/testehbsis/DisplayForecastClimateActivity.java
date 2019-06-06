package com.zoardgeocze.testehbsis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class DisplayForecastClimateActivity extends AppCompatActivity {

    private RecyclerView displayForecastRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_forecast_climate);
    }
}
