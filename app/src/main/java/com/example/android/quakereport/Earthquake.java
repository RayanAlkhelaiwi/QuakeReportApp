package com.example.android.quakereport;

import java.text.SimpleDateFormat;

/**
 * Created by Rean on 9/27/2017.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long timeInMilliseconds) {

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        String magnitudeString = "" + mMagnitude;
        return magnitudeString;
    }

    public String getLocation() {
        return mLocation;
    }

    public String formatDate() {

        //Date date = new Date(mDate);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM DD, YYYY"); //(SimpleDateFormat) DateFormat.getDateTimeInstance();
        String dateString = sdf.format(mTimeInMilliseconds /*date*/);
        return dateString;
    }

    public String formatTime() {

        //Date date = new Date(mDate);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); //(SimpleDateFormat) DateFormat.getDateTimeInstance();
        String timeString = sdf.format(mTimeInMilliseconds /*date*/);
        return timeString;
    }
}
