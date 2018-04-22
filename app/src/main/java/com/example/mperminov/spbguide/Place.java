package com.example.mperminov.spbguide;

import java.time.LocalDate;
import java.time.Period;

/**
 * Custom object to store info about certain place.
 */
public class Place {
    private String mName;
    private String mShortDescription;
    private int mImageId;
    private LocalDate mDate;
    private String mWorkingHours;

    //default constructor
    public Place(String name, String shortDescription, int imageId) {
        mName = name;
        mShortDescription = shortDescription;
        mImageId = imageId;
    }

    //constructor for events - concerts, performances with certain date
    public Place(String name, String shortDescription, int imageId, LocalDate date) {
        mName = name;
        mShortDescription = shortDescription;
        mImageId = imageId;
        mDate = date;
    }

    //constructor for objects with working time - restaurants, pubs.
    public Place(String name, String shortDescription, int imageId, String workingHours) {
        mName = name;
        mShortDescription = shortDescription;
        mImageId = imageId;
        mWorkingHours = workingHours;
    }


    public String getmName() {
        return mName;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public int getmImageId() {
        return mImageId;
    }

    /**
     * Calculate period between event and current time
     *
     * @return string dependent on when when an event will occur
     * e.g. "in 6 das(s)"; "today"; "3 day(s) ago"
     */
    public String daysUntil() {
        String dateText = null;
        LocalDate today = LocalDate.now();
        Period p = Period.between(today, mDate);
        if (p.getDays() > 0) {
            dateText = "in " + p.getDays() + " day(s)";
        } else if (p.getDays() == 0) {
            dateText = "today";
        } else if (p.getDays() < 0) {
            dateText = Math.abs(p.getDays()) + " day(s) ago";
        }
        return dateText;
    }

    public String getmWorkingHours() {
        return mWorkingHours;
    }
}

