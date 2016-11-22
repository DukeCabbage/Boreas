package com.cabbage.boreas.applicaton;

import com.cabbage.boreas.weatherApi.WeatherManager;
import com.cabbage.boreas.weatherApi.WeatherMangerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public WeatherManager providesWeatherManager() {
        return new WeatherMangerImpl();
    }
}
