package com.cabbage.boreas.model.darkskyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DataPoint {

    @SerializedName("time")
    @Expose
    public int time;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("sunriseTime")
    @Expose
    public int sunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    public int sunsetTime;
    @SerializedName("moonPhase")
    @Expose
    public float moonPhase;
    @SerializedName("precipAccumulation")
    @Expose
    public float precipAccumulation;
    @SerializedName("precipIntensity")
    @Expose
    public float precipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    public float precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    public int precipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    public float precipProbability;
    @SerializedName("precipType")
    @Expose
    public String precipType;
    @SerializedName("temperature")
    @Expose
    public float temperature;
    @SerializedName("temperatureMin")
    @Expose
    public float temperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    public int temperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    public float temperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    public int temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    public float apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    public int apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    public float apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    public int apparentTemperatureMaxTime;
    @SerializedName("dewPoint")
    @Expose
    public float dewPoint;
    @SerializedName("humidity")
    @Expose
    public float humidity;
    @SerializedName("windSpeed")
    @Expose
    public float windSpeed;
    @SerializedName("windBearing")
    @Expose
    public int windBearing;
    @SerializedName("cloudCover")
    @Expose
    public float cloudCover;
    @SerializedName("pressure")
    @Expose
    public float pressure;
    @SerializedName("ozone")
    @Expose
    public float ozone;

    @Override
    public String toString() {
        return "DataPoint{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", sunriseTime=" + sunriseTime +
                ", sunsetTime=" + sunsetTime +
                ", moonPhase=" + moonPhase +
                ", precipIntensity=" + precipIntensity +
                ", precipIntensityMax=" + precipIntensityMax +
                ", precipIntensityMaxTime=" + precipIntensityMaxTime +
                ", precipProbability=" + precipProbability +
                ", precipType='" + precipType + '\'' +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMinTime=" + temperatureMinTime +
                ", temperatureMax=" + temperatureMax +
                ", temperatureMaxTime=" + temperatureMaxTime +
                ", apparentTemperatureMin=" + apparentTemperatureMin +
                ", apparentTemperatureMinTime=" + apparentTemperatureMinTime +
                ", apparentTemperatureMax=" + apparentTemperatureMax +
                ", apparentTemperatureMaxTime=" + apparentTemperatureMaxTime +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windBearing=" + windBearing +
                ", cloudCover=" + cloudCover +
                ", pressure=" + pressure +
                ", ozone=" + ozone +
                '}';
    }
}