package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastClimateResponse {

    public City city;

}
