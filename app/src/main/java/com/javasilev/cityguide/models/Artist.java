package com.javasilev.cityguide.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class Artist extends RealmObject implements Serializable {
    @SerializedName("Id")
    @PrimaryKey
    private int mId;
    @SerializedName("CityId")
    private int mCityId;
    @SerializedName("Age")
    private int mAge;
    @SerializedName("FirstName")
    private String mFirstname;
    @SerializedName("LastName")
    private String mLastname;
    @SerializedName("Description")
    private String mDescription;
    @SerializedName("Email")
    private String mEmail;
    @SerializedName("Phone")
    private String mPhone;
    @SerializedName("Viber")
    private String mViber;
    @SerializedName("Images")
    private RealmList<Image> mImageList;

    public Artist() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getCityId() {
        return mCityId;
    }

    public void setCityId(int mCityid) {
        this.mCityId = mCityid;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String mFirstname) {
        this.mFirstname = mFirstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String mLastname) {
        this.mLastname = mLastname;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getViber() {
        return mViber;
    }

    public void setViber(String mViber) {
        this.mViber = mViber;
    }

    public RealmList<Image> getImageList() {
        return mImageList;
    }

    public void setImageList(RealmList<Image> mImages) {
        this.mImageList = mImages;
    }

    public static class Columns {
        public static final String ID = "mId";
        public static final String CITY_ID = "mId";
        public static final String AGE = "mId";
        public static final String FIRSTNAME = "mId";
        public static final String LASTNAME = "mId";
        public static final String DESCRIPTION = "mId";
        public static final String EMAIL = "mId";
        public static final String PHONE = "mId";
        public static final String VIBER = "mId";
        public static final String IMAGES = "mImageList";
    }
}
