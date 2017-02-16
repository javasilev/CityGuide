package com.javasilev.cityguide.network.urls;

import android.content.Context;

import com.javasilev.cityguide.R;

/**
 * Created by Aleksei Vasilev.
 */

public class CountryApiUrls {
    private static final String BASE = "/api";
    public static final String API = BASE + "/countries";

    public static String getBaseApiUrl(Context context) {
        return context.getString(R.string.base_api_url);
    }
}
