package com.example.android.quakereport;

import java.text.SimpleDateFormat;

/**
 * Created by Rean on 9/27/2017.
 */

public class Earthquake {

    String mUrl;
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String formatDate() {
        //Date date = new Date(mDate);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, YYYY"); //(SimpleDateFormat) DateFormat.getDateTimeInstance();
        String dateString = sdf.format(mTimeInMilliseconds /*date*/);
        return dateString;
    }

    public String formatTime() {
        //Date date = new Date(mDate);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); //(SimpleDateFormat) DateFormat.getDateTimeInstance();
        String timeString = sdf.format(mTimeInMilliseconds /*date*/);
        return timeString;
    }

    public String getUrl() {
        return mUrl;
    }
}
