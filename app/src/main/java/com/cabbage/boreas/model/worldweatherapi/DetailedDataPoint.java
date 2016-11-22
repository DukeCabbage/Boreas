package com.cabbage.boreas.model.worldweatherapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DetailedDataPoint {

    @SerializedName("tempC")
    @Expose
    public String tempC;
    @SerializedName("tempF")
    @Expose
    public String tempF;
    @SerializedName("weatherCode")
    @Expose
    public String weatherCode;
    //    @SerializedName("weatherDesc")
//    @Expose
//    public List<WeatherDesc> weatherDesc = new ArrayList<WeatherDesc>();
//    @SerializedName("weatherIconUrl")
//    @Expose
//    public List<WeatherIconUrl> weatherIconUrl = new ArrayList<WeatherIconUrl>();
    @SerializedName("winddir16Point")
    @Expose
    public String winddir16Point;
    @SerializedName("winddirDegree")
    @Expose
    public String winddirDegree;
    @SerializedName("windspeedKmph")
    @Expose
    public String windspeedKmph;
    @SerializedName("windspeedMiles")
    @Expose
    public String windspeedMiles;

}