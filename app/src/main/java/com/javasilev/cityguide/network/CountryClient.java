package com.javasilev.cityguide.network;

import com.javasilev.cityguide.models.Response;
import com.javasilev.cityguide.network.urls.CountryApiUrls;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public interface CountryClient {

    @GET(CountryApiUrls.API)
    Observable<Response> getCountryApiResponse();
}
