package com.cabbage.boreas.model.worldweatherapi;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Weather {

    @SerializedName("astronomy")
    @Expose
    public List<Astronomy> astronomy = new ArrayList<Astronomy>();
    @SerializedName("bottom")
    @Expose
    public List<DataPoint> bottom = new ArrayList<DataPoint>();
    @SerializedName("chanceofsnow")
    @Expose
    public String chanceofsnow;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = new ArrayList<Hourly>();
    @SerializedName("mid")
    @Expose
    public List<DataPoint> mid = new ArrayList<DataPoint>();
    @SerializedName("top")
    @Expose
    public List<DataPoint> top = new ArrayList<DataPoint>();
    @SerializedName("totalSnowfall_cm")
    @Expose
    public String totalSnowfallCm;

}