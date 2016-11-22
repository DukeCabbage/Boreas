package com.cabbage.boreas.model.worldweatherapi;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Request {

    @SerializedName("query")
    @Expose
    public String query;
    @SerializedName("type")
    @Expose
    public String type;

}