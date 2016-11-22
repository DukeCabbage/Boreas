package com.cabbage.boreas.model.worldweatherapi;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("request")
    @Expose
    public List<Request> request = new ArrayList<Request>();
    @SerializedName("time_zone")
    @Expose
    public List<TimeZone> timeZone = new ArrayList<TimeZone>();
    @SerializedName("weather")
    @Expose
    public List<Object> weather = new ArrayList<Object>();

}