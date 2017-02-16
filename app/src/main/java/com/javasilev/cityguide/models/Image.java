package com.javasilev.cityguide.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

@SuppressWarnings("unused")
public class Image extends RealmObject implements Serializable {
    @SerializedName("ImageLink")
    private String mImageLink;
    @SerializedName("ShouldShowWatermark")
    private boolean mShouldShowWatermark;

    public Image() {
    }

    public String getImageLink() {
        return mImageLink;
    }

    public void setImageLink(String mImagelink) {
        this.mImageLink = mImagelink;
    }

    public boolean getShouldShowWatermark() {
        return mShouldShowWatermark;
    }

    public void setShouldShowWatermark(boolean mShouldshowwatermark) {
        this.mShouldShowWatermark = mShouldshowwatermark;
    }

    public static class Columns {
        public static final String IMAGE_LINK = "mImageLink";
        public static final String WATERMARK = "mShouldShowWatermark";
    }
}
