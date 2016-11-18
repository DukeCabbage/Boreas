package com.cabbage.boreas.applicaton;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetworkModule.class, DataModule.class})
public interface AppComponent {

    @Named("DarkSky")
    Retrofit darkSkyRetrofit();

    WeatherManager weatherManager();
}
