package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Rean on 9/27/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private final String LOCATION_SEPERATOR = " of ";
    private String locationOffset;
    private String primaryLocation;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakeArrayList) {
        super(context, 0, earthquakeArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        //If the list is null, do the inflater
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        Earthquake earthquakeAdapterItem = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        magnitudeTextView.setText(formatMag(earthquakeAdapterItem.getMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(getMagnitudeColor(earthquakeAdapterItem.getMagnitude()));

        String originalLocation = earthquakeAdapterItem.getLocation();

        if (originalLocation.contains(LOCATION_SEPERATOR)) {
            String[] locationArray = originalLocation.split(LOCATION_SEPERATOR);
            locationOffset = locationArray[0] + LOCATION_SEPERATOR;
            primaryLocation = locationArray[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        primaryLocationTextView.setText(primaryLocation);

        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(locationOffset);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(earthquakeAdapterItem.formatDate());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(earthquakeAdapterItem.formatTime());

        return listItemView;
    }

    private int getMagnitudeColor(double mag) {
        int magColorID;
        int magFloor = (int) Math.floor(mag);
        switch (magFloor) {

            case 0:
            case 1:
                magColorID = R.color.magnitude1;
                break;
            case 2:
                magColorID = R.color.magnitude2;
                break;
            case 3:
                magColorID = R.color.magnitude3;
                break;
            case 4:
                magColorID = R.color.magnitude4;
                break;
            case 5:
                magColorID = R.color.magnitude5;
                break;
            case 6:
                magColorID = R.color.magnitude6;
                break;
            case 7:
                magColorID = R.color.magnitude7;
                break;
            case 8:
                magColorID = R.color.magnitude8;
                break;
            case 9:
                magColorID = R.color.magnitude9;
                break;

            default:
                magColorID = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magColorID);
    }

    private String formatMag(double mag) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(mag);
    }
}
