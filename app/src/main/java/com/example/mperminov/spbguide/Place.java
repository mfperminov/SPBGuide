package com.example.mperminov.spbguide;

public class Place {
    String mName;
    String mShortDecription;
    int mImageId;

    public Place(String name, String shortDescription, int imageId) {
        mName = name;
        mShortDecription = shortDescription;
        mImageId = imageId;
    }

    public String getmName() {
        return mName;
    }

    public String getmShortDecription() {
        return mShortDecription;
    }

    public int getmImageId() {
        return mImageId;
    }
}
