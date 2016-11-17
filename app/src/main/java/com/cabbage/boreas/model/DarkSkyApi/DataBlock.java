package com.cabbage.boreas.model.darkskyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DataBlock {

    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("data")
    @Expose
    public List<DataPoint> data = new ArrayList<>();

    @Override
    public String toString() {
        return "DataBlock{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}