package com.mlgrier.booklistingapp;

/**
 * {@Event} represents an earthquake event. It holds the details
 * of that event such as title (which contains magnitude and location
 * of the earthquake), as well as time, and whether or not a tsunami
 * alert was issued during the earthquake.
 */
public class Book {

    /**
     * Title of the earthquake event
     */
    public final String title;

    /**
     * Time that the earthquake happened (in milliseconds)
     */
    public final long time;

    /**
     * Whether or not a tsunami alert was issued (1 if it was issued, 0 if no alert was issued)
     */
    public final int tsunamiAlert;

    /**
     * Constructs a new {@link Book}.
     *
     * @param eventTitle        is the title of the earthquake event
     * @param eventTime         is the time the earhtquake happened
     * @param eventTsunamiAlert is whether or not a tsunami alert was issued
     */
    public Book(String eventTitle, long eventTime, int eventTsunamiAlert) {
        title = eventTitle;
        time = eventTime;
        tsunamiAlert = eventTsunamiAlert;
    }

    //Magnitude of the earthquake
    private double mMagnitude;

    //Location of the earthquake
    private String mQuakeLocation;

    //Date of the of the earthquake event
    private long mTimeInMilliseconds;

    //website URL of the earthquake
    private String mUrl;



    public Earthquake(double magnitude, String quakeLocation, long timeInMilliseconds, String url) {
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
    public String getUrl() { return mUrl; }
}
