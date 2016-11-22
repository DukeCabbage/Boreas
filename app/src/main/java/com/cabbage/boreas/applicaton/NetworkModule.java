package com.cabbage.boreas.applicaton;

import com.cabbage.boreas.model.darkskyapi.Result;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

@Module
public class NetworkModule {

    private final static String DARK_SKY_BASE_URL = "https://api.darksky.net/forecast/";
    private final static String DARK_SKY_API_KEY = "f2778d0372266ff4099d2ee062db20bf";

    private final static String WORLD_WEATHER_BASE_URL = "http://api.worldweatheronline.com/premium/v1/";
    private final static String WORLD_WEATHER_API_KEY = "6bad844eed5e4b67a44211226160911";

    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConvertorFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public RxJavaCallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    @Named("DarkSky")
    public Retrofit providesDarkSkyRetrofit(GsonConverterFactory gsonConverterFactory,
                                            RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                                            OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(DARK_SKY_BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    @Singleton
    @Named("WorldWeather")
    public Retrofit providesWorldWeatherRetrofit(GsonConverterFactory gsonConverterFactory,
                                            RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                                            OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(WORLD_WEATHER_BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    public interface DarkSkyApi {

        @GET(DARK_SKY_API_KEY + "/{latlng}?exclude=minutely,hourly&units=si")
        Observable<Result> simpleGetWeather(@Path("latlng") String latLng);
    }

    public interface  WorldWeatherApi {
    }
}
