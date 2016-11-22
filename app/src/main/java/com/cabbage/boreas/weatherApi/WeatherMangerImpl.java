package com.cabbage.boreas.weatherApi;

import com.cabbage.boreas.applicaton.MyApplication;
import com.cabbage.boreas.applicaton.NetworkModule;
import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.darkskyapi.Result;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class WeatherMangerImpl implements WeatherManager {

    @Override
    public Observable<Result> getDarkSkyWeather(String latLng) {
        Retrofit retrofit = MyApplication.getAppComponent().darkSkyRetrofit();
        return retrofit.create(NetworkModule.DarkSkyApi.class).simpleGetWeather(latLng);
    }

    @Override
    public Observable<List<BoreasDataPoint>> getMyWeather(String latLng) {
        return getDarkSkyWeather(latLng).flatMap(new DarkSkyDataConverter());
    }
}
