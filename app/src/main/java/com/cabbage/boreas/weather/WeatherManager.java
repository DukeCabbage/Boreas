package com.cabbage.boreas.weather;

import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.Resort;

import rx.Observable;

public interface WeatherManager {

    Observable<BoreasDataPoint> getWeatherForLatLng(float lat, float lng);
    Observable<BoreasDataPoint> getWeatherForResort(Resort resort);
}
