package com.cabbage.boreas.model;

import java.util.ArrayList;
import java.util.List;

public class Resort {

    public static List<Resort> dummies = new ArrayList<>();

    static {
        Resort whistler = new Resort("whistler", "Whistler Blackcomb");
        whistler.latitude = 50.108333f;
        whistler.longitude = -122.9425f;
        whistler.country = CountryEnum.Canada.getCode();
        dummies.add(whistler);

        Resort alpe = new Resort("lalpe-dHuez", "L'Alpe d'Huez");
        alpe.latitude = 45.060278f;
        alpe.longitude = 6.071389f;
        alpe.country = CountryEnum.France.getCode();
        dummies.add(alpe);
    }

    public String identifier;
    public String displayName;
    public String country;
    public float latitude;
    public float longitude;
    public List<String> tags;
    public int lastUpdate;

    public Resort() {}

    public Resort(String identifier, String displayName) {
        this.identifier = identifier;
        this.displayName = displayName;
    }
}
