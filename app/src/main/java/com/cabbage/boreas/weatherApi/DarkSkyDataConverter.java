package com.cabbage.boreas.weatherApi;

import com.cabbage.boreas.model.BoreasDataPoint;
import com.cabbage.boreas.model.darkskyapi.DataBlock;
import com.cabbage.boreas.model.darkskyapi.DataPoint;
import com.cabbage.boreas.model.darkskyapi.Result;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class DarkSkyDataConverter implements Func1<Result, Observable<List<BoreasDataPoint>>> {

    @Override
    public Observable<List<BoreasDataPoint>> call(Result result) {
        DataBlock dailyList = result.daily;
        int dataSize = dailyList.data.size();

        if (dataSize == 0) {
            return Observable.just(new ArrayList<>());
        } else {
            List<BoreasDataPoint> dataPoints = new ArrayList<>(dataSize);

            for (DataPoint dataPoint : dailyList.data) {
                BoreasDataPoint boreasDataPoint = new BoreasDataPoint();
                boreasDataPoint.timeZone = result.timezone;
                boreasDataPoint.time = dataPoint.time * 1000;
                boreasDataPoint.temperature = 0.0f * dataPoint.temperatureMax + 1.0f * dataPoint.temperatureMin;
                boreasDataPoint.rainChance = dataPoint.precipProbability;
                if (dataPoint.precipType.equalsIgnoreCase("snow")) {
                    boreasDataPoint.precipitation = 0.0f;
                    boreasDataPoint.snowPrecipitation = dataPoint.precipIntensity;
                } else {
                    boreasDataPoint.precipitation = dataPoint.precipIntensity;
                    boreasDataPoint.snowPrecipitation = 0.0f;
                }

                boreasDataPoint.accumulatedSnowPrecipitation = dataPoint.precipAccumulation;

                dataPoints.add(boreasDataPoint);
            }

            return Observable.just(dataPoints);
        }
    }
}
