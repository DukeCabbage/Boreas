package com.cabbage.boreas.model;

import java.util.ArrayList;
import java.util.List;

public class Resort {

    public String identifier;
    public String displayName;
    public String country;
    public double latitude;
    public double longitude;
    public List<String> tags;

    public Resort() {}

    public Resort(String identifier, String displayName) {
        this.identifier = identifier;
        this.displayName = displayName;
    }

    public static List<Resort> dummies = new ArrayList<>();

    static {
        Resort whistler = new Resort("whistler", "Whistler Blackcomb");
        whistler.latitude = 50.108333;
        whistler.longitude = -122.9425;
        whistler.country = CountryEnum.Canada.getCode();
        dummies.add(whistler);

        Resort alpe = new Resort("lalpe-dHuez", "L'Alpe d'Huez");
        alpe.latitude = 45.060278;
        alpe.longitude = 6.071389;
        alpe.country = CountryEnum.France.getCode();
        dummies.add(alpe);
    }
}
