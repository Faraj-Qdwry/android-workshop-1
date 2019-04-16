package com.aqsoft.newapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class TempData {

    public int temp;
    public String unit;
    public Double humidity;

    public TempData(){

    }

    public int getTemp() {
        return temp;
    }

    public String getUnit() {
        return unit;
    }

    public Double getHumidity() {
        return humidity;
    }
}
