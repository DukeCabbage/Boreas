package com.cabbage.boreas.model.worldweatherapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Hourly {

    @SerializedName("bottom")
    @Expose
    public List<DetailedDataPoint> bottom = new ArrayList<DetailedDataPoint>();
    @SerializedName("chanceoffog")
    @Expose
    public String chanceoffog;
    @SerializedName("chanceoffrost")
    @Expose
    public String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    public String chanceofhightemp;
    @SerializedName("chanceofovercast")
    @Expose
    public String chanceofovercast;
    @SerializedName("chanceofrain")
    @Expose
    public String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    public String chanceofremdry;
    @SerializedName("chanceofsnow")
    @Expose
    public String chanceofsnow;
    @SerializedName("chanceofsunshine")
    @Expose
    public String chanceofsunshine;
    @SerializedName("chanceofthunder")
    @Expose
    public String chanceofthunder;
    @SerializedName("chanceofwindy")
    @Expose
    public String chanceofwindy;
    @SerializedName("cloudcover")
    @Expose
    public String cloudcover;
    @SerializedName("freezeLevel")
    @Expose
    public String freezeLevel;
    @SerializedName("humidity")
    @Expose
    public String humidity;
    @SerializedName("isdaytime")
    @Expose
    public String isdaytime;
    @SerializedName("mid")
    @Expose
    public List<DetailedDataPoint> mid = new ArrayList<DetailedDataPoint>();
    @SerializedName("precipMM")
    @Expose
    public String precipMM;
    @SerializedName("pressure")
    @Expose
    public String pressure;
    @SerializedName("snowfall_cm")
    @Expose
    public String snowfallCm;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("top")
    @Expose
    public List<DetailedDataPoint> top = new ArrayList<DetailedDataPoint>();
    @SerializedName("visibility")
    @Expose
    public String visibility;

}