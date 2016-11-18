package com.cabbage.boreas.applicaton;

import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.darkskyapi.Result;

import rx.Observable;

class WeatherMangerImpl implements WeatherManager {

    @Override
    public Observable<Result> getDarkSkyWeather(String latlng) {
        return null;
    }

    @Override
    public Observable<BoreasDataPoint> getMyWeather(String latlng) {
        return null;
    }
}
