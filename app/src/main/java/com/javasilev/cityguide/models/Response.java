package com.javasilev.cityguide.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("unused")
public class Response {

    @SerializedName("Timestamp")
    private String mTimestamp;
    @SerializedName("Error")
    private String mError;
    @SerializedName("Result")
    private List<Country> mCountryList;

    public Response() {
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public String getError() {
        return mError;
    }

    public void setError(String mError) {
        this.mError = mError;
    }

    public List<Country> getCountryList() {
        return mCountryList;
    }

    public void setCountryList(List<Country> mCountry) {
        this.mCountryList = mCountry;
    }
}
