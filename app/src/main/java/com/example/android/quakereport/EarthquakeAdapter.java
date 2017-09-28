package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rean on 9/27/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private final String LOCATION_SEPERATOR = " of ";
    private String locationOffset;
    private String primaryLocation;

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakeArrayList) {
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
        magnitudeTextView.setText(earthquakeAdapterItem.getMagnitude());

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
}
