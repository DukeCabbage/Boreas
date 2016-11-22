package com.cabbage.boreas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.cabbage.boreas.applicaton.MyApplication;
import com.cabbage.boreas.model.BoreasDataPoint;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DarkSkyFragment extends Fragment {

    @BindView(R.id.et_latitude) EditText etLatitude;
    @BindView(R.id.et_longitude) EditText etLongitude;
    @BindView(R.id.rv_weather) RecyclerView mRecyclerView;
    Unbinder unbinder;
    WeatherRecyclerViewAdapter mAdapter;

    public DarkSkyFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.btn_request)
    void sendRequest(View view) {
        String lat = etLatitude.getText().toString();
        String lng = etLongitude.getText().toString();

        MyApplication.getAppComponent().weatherManager().getMyWeather(lat + "," + lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<BoreasDataPoint>>() {
                    @Override
                    public void onCompleted() {
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<BoreasDataPoint> boreasDataPoints) {
                        mAdapter.setItems(boreasDataPoints);
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dark_sky, container, false);
        unbinder = ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new WeatherRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
    }
}
