package com.cabbage.boreas.weather;

import com.cabbage.boreas.model.DataPoint;
import com.cabbage.boreas.model.Resort;

import rx.Observable;

public interface WeatherManager {

    Observable<DataPoint> getWeatherForLatLng(float lat, float lng);
    Observable<DataPoint> getWeatherForResort(Resort resort);
}
