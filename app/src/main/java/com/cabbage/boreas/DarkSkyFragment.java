package com.cabbage.boreas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cabbage.boreas.applicaton.MyApplication;
import com.cabbage.boreas.applicaton.NetworkModule;
import com.cabbage.boreas.model.darkskyapi.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class DarkSkyFragment extends Fragment {

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

        Retrofit retrofit = MyApplication.getAppComponent().darkSkyRetrofit();

        retrofit.create(NetworkModule.DarkSkyApi.class).simpleGetWeather(lat + "," + lng)
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
}
