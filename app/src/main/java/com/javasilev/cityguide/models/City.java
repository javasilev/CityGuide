package com.javasilev.cityguide.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class City extends RealmObject implements Serializable {
    @SerializedName("Id")
    @PrimaryKey
    private int mId;
    @SerializedName("CountryId")
    private int mCountryId;
    @SerializedName("Name")
    private String mName;
    @SerializedName("ImageLink")
    private String mImageLink;
    @SerializedName("Artists")
    private RealmList<Artist> mArtistList;

    public City() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getCountryId() {
        return mCountryId;
    }

    public void setCountryId(int mCountryid) {
        this.mCountryId = mCountryid;
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

    public RealmList<Artist> getArtistList() {
        return mArtistList;
    }

    public void setArtistList(RealmList<Artist> mArtists) {
        this.mArtistList = mArtists;
    }

    public static class Columns {
        public static final String ID = "mId";
        public static final String COUNTRY_ID = "mCountryId";
        public static final String NAME = "mName";
        public static final String IMAGE_LINK = "mImageLink";
        public static final String ARTISTS = "mArtistList";
    }
}
