package com.cabbage.boreas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cabbage.boreas.model.darkskyapi.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class DarkSkyFragment extends Fragment {

    public final static String DARK_SKY_BASE_URL = "https://api.darksky.net/forecast/";
    public final static String DARK_SKY_API_KEY = "f2778d0372266ff4099d2ee062db20bf";

    @BindView(R.id.et_latitude) EditText etLatitude;
    @BindView(R.id.et_longitude) EditText etLongitude;
    Unbinder unbinder;

    public DarkSkyFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.btn_request)
    void sendRequest() {
        String lat = etLatitude.getText().toString();
        String lng = etLongitude.getText().toString();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        Retrofit retrofit = provideDarkSkyRetrofit(GsonConverterFactory.create(),
                RxJavaCallAdapterFactory.create(),
                logging);

        retrofit.create(DarkSkyApi.class).simpleGetWeather(DARK_SKY_API_KEY, lat + "," + lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(getContext(), "Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Result result) {
                        if (result != null) {
                            Timber.d(result.toString());
                        }
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dark_sky, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
    }

    protected Retrofit provideDarkSkyRetrofit(GsonConverterFactory gsonConverterFactory,
                                              RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                                              HttpLoggingInterceptor logging) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        return new Retrofit.Builder()
                .baseUrl(DARK_SKY_BASE_URL)
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    public interface DarkSkyApi {

        @GET("{api_key}/{latlng}?exclude=minutely,hourly&units=si")
        Observable<Result> simpleGetWeather(@Path("api_key") String apiKey, @Path("latlng") String latLng);
    }
}
