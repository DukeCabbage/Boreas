package com.cabbage.boreas.applicaton;

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
