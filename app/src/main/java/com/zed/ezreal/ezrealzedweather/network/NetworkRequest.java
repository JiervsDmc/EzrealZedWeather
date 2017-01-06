package com.zed.ezreal.ezrealzedweather.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jiervs on 2017/1/6.
 */
public class NetworkRequest {

    public static final String BASE_URL = "https://free-api.heweather.com/v5/";

    public static retrofit2.Retrofit getInitRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
