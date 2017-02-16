package com.javasilev.cityguide.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class Country extends RealmObject implements Serializable {
    @SerializedName("Id")
    @PrimaryKey
    private int mId;
    @SerializedName("Name")
    private String mName;
    @SerializedName("ImageLink")
    private String mImageLink;
    @SerializedName("Cities")
    private RealmList<City> mCityList;

    public Country() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImageLink() {
        return mImageLink;
    }

    public void setImageLink(String mImagelink) {
        this.mImageLink = mImagelink;
    }

    public RealmList<City> getCityList() {
        return mCityList;
    }

    public void setCityList(RealmList<City> mCities) {
        this.mCityList = mCities;
    }

    public static class Columns {
        public static final String ID = "mId";
        public static final String NAME = "mName";
        public static final String IMAGE_LINK = "mImageLink";
        public static final String CITIES = "mCityList";
    }
}
