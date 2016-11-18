package com.cabbage.boreas.applicaton;

import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.darkskyapi.Result;

import rx.Observable;

public interface WeatherManager {

    Observable<Result> getDarkSkyWeather(String latlng);

    Observable<BoreasDataPoint> getMyWeather(String latlng);
}
