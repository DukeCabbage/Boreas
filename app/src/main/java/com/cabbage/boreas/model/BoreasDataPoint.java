package com.cabbage.boreas.model;

import com.google.firebase.database.Exclude;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BoreasDataPoint {

    public String resortIdentifier;
    public int milliSeconds;

    public float temperature;
    public float rainChance;

    public float precipitation;
    public float snowPrecipitation;
    public float accumulatedSnowPrecipitation;

    @Exclude
    private Date date;

    public Date getDate() {
//        if (date == null) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"), Locale.CANADA);
            calendar.setTimeInMillis(milliSeconds);
            date = calendar.getTime();
//        }

        return date;
    }


}
