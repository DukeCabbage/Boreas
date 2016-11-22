package com.cabbage.boreas.weatherApi;

import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.darkskyapi.Result;

import java.util.List;

import rx.Observable;

public interface WeatherManager {

    Observable<Result> getDarkSkyWeather(String latlng);

    Observable<List<BoreasDataPoint>> getMyWeather(String latlng);
}
