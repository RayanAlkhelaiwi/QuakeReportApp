package com.example.android.quakereport;

import java.text.SimpleDateFormat;

/**
 * Created by Rean on 9/27/2017.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mDate;

    public Earthquake(double magnitude, String location, long date) {

        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public String getMagnitude() {
        String magnitudeString = "" + mMagnitude;
        return magnitudeString;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        mDate = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        String dateString = sdf.format(mDate);
        return dateString;
    }
}
