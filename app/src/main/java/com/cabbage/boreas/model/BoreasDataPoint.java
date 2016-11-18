package com.cabbage.boreas.model;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class BoreasDataPoint {

    public static List<BoreasDataPoint> dummies = new ArrayList<>();

    static {
        String testTimeZone = "America/Vancouver";

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(testTimeZone), Locale.getDefault());
        calendar.set(2016, Calendar.NOVEMBER, 17, 17, 0, 0);
        long testStartTime = calendar.getTimeInMillis();
        long milliSecInDay = 24 * 2600 * 1000L;


        for (int i = 0; i < 5; i++) {
            BoreasDataPoint point = new BoreasDataPoint();
            point.resortIdentifier = "whislter";
            point.timeZone = testTimeZone;
            point.time = testStartTime + i *milliSecInDay;

            point.temperature = 6 + new Random().nextInt(3);
            point.rainChance = new Random().nextFloat();
            point.precipitation = new Random().nextFloat() * 10f;
            point.snowPrecipitation =  new Random().nextFloat() * 10f;
            point.snowPrecipitation = Math.min(point.precipitation, point.snowPrecipitation);

            point.accumulatedSnowPrecipitation = new Random().nextFloat() * 30f;
        }
    }

    public String resortIdentifier;
    public String timeZone;
    public long time;
    public float temperature;
    public float rainChance;
    public float precipitation;
    public float snowPrecipitation;
    public float accumulatedSnowPrecipitation;
    @Exclude
    private Date date;

    public Date getDate() {
//        if (date == null) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone), Locale.getDefault());
        calendar.setTimeInMillis(time);
        date = calendar.getTime();
//        }

        return date;
    }

}
