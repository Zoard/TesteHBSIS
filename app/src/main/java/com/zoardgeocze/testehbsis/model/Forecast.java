package com.zoardgeocze.testehbsis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast implements Serializable {

    private long dt;
    private Weather main;

    public Forecast() {
        this.dt = 0;
        this.main = new Weather();
    }

    public long getDt() {
        return dt;
    }

    public Weather getMain() {
        return main;
    }
}
