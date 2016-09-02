package com.mlgrier.booklistingapp;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mlgrier on 9/1/16.
 */
public class BookAdapter extends ArrayAdapter<Book> {



    private static final String LOCATION_SEPARATOR = " of ";


    // context is the current context (i.e. Activity) that the adapter is being created in
    // detail is the list of detail to be displayed.
    // colorResourceId is the resource ID for the background color for this list of detail
    public BookAdapter(Activity context, ArrayList<Book> earth) {
        super(context, 0, earth);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if there is an existing list item view (called convertView) that we can reuse,
        //otherwise, if convertiView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list, parent, false);

        }

        //find the earthquake at the give position in the list of earthquakes
        Book currentBook = getItem(position);

        //Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        //format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentBook.getMagnitude());

        //display the magnitude of the current earthquake in the TextView
        magnitudeView.setText(formattedMagnitude);


        //set the proper background color on the magnitude circle.
        //fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        //get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentBook.getMagnitude());

        //set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //Get the original location string from the Earthquake object,
        //which can be in the format of "5km N of Cairo, Egypt" or "Pacific-Antrarctic Ridge"
        String originalLocation = currentBook.getQuakeLocation();

        //If the original location string (i.e. "5km N of Cairo, Egypt") contains
        //a primary location (Cairo, Egypt) and a location offset (5km N of that city)
        //then store the primary location separately from the location offset in 2 strings,
        //so they can be displayed in 2 TextViews.
        String primaryLocation;
        String locationOffset;

        //Check whether the originalLocation string contains the "of" text
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            //split the string into different parts (as an array of strings)
            //based on the "of" text. We expect an array of 2 Strings, where
            //the first string will be "5km N" and the second String will be "Cairo, Egypt"
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            //Location offset should be "5km N" + "of" --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            //Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        }else {
            //otherwise, there is no "of" text in the originalLocation string.
            //Hence, set the default location offset to say "Near the"
            locationOffset = getContext().getString(R.string.near_the);
            //The primary location will be the full location string "Pacific-Antarctic Ridge"
            primaryLocation = originalLocation;
        }


        //Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);

        //Display the location of the current earthquake in that TextView
        primaryLocationView.setText(primaryLocation);

        //Find the TextView with view ID location
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);

        //Display the location of the current earthquake in that TextView
        locationOffsetView.setText(locationOffset);

        //create a new date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentBook.getTimeInMilliseconds());

        //Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        //Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);

        //Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        //Find that TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        //Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);

        //Display the time of the current earthquake in the TextView
        timeView.setText(formattedTime);

        //Return the list item view that is now showing the appropriate date
        return listItemView;

    }

    //Return the formatted date string (i.e. "Mar 3, 1984") from a date object
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    //Return the formatted date string (i.e. "4:30PM") from a date object
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);

    }

    //return the formatted magnitude string showing 1 decimal place (i.e. "3.2"),
    //from a decimal magnitude value.
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

}
