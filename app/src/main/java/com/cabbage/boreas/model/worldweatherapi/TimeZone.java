package com.cabbage.boreas.model.worldweatherapi;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TimeZone {

    @SerializedName("localtime")
    @Expose
    public String localtime;
    @SerializedName("utcOffset")
    @Expose
    public String utcOffset;

}