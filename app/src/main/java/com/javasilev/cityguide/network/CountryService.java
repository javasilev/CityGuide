package com.javasilev.cityguide.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.javasilev.cityguide.network.urls.CountryApiUrls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("unused")
public class CountryService {
    private final Retrofit mRetrofit;

    public CountryService(Context context) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(CountryApiUrls.getBaseApiUrl(context))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(createOkHttpClient())
                .build();
    }

    @NonNull
    private OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public CountryClient createCountryClient() {
        return mRetrofit.create(CountryClient.class);
    }
}
