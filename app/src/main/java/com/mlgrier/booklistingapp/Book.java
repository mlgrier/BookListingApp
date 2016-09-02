package com.mlgrier.booklistingapp;

/**
 * {@Book} represents an earthquake event. It holds the details
 * of that event such as title (which contains magnitude and location
 * of the earthquake), as well as time, and whether or not a tsunami
 * alert was issued during the earthquake.
 */
public class Book {

    //Magnitude of the earthquake
    private double mMagnitude;

    //Location of the earthquake
    private String mQuakeLocation;

    //Date of the of the earthquake event
    private long mTimeInMilliseconds;

    //website URL of the earthquake
    private String mUrl;


    public Book(double magnitude, String quakeLocation, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mQuakeLocation = quakeLocation;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;

    }

    // Get the magnitude of the quake.
    public double getMagnitude() {
        return mMagnitude;
    }

    // Get the location of the quake.
    public String getQuakeLocation() {
        return mQuakeLocation;
    }

    // Get the date of the quake.
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    //get the url of the earthquake
    public String getUrl() {
        return mUrl;
    }
}