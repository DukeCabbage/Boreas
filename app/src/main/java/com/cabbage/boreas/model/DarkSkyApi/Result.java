package com.cabbage.boreas.model.darkskyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("latitude")
    @Expose
    public float latitude;
    @SerializedName("longitude")
    @Expose
    public float longitude;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("offset")
    @Expose
    public int offset;
    @SerializedName("currently")
    @Expose
    public DataPoint currently;
    @SerializedName("hourly")
    @Expose
    public DataBlock hourly;
    @SerializedName("daily")
    @Expose
    public DataBlock daily;

    @Override
    public String toString() {
        return "Result{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", offset=" + offset +
                '}';
    }
}