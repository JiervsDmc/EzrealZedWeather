package com.zed.ezreal.ezrealzedweather;

import android.app.Application;

import com.google.gson.Gson;
import com.zed.ezreal.ezrealzedweather.network.NetworkConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Jiervs on 2017/3/30.
 */

public class EZWApplication extends Application {

    public static Gson App_Gson;//全局gson对象
    public static Retrofit App_Retrofit;//全局retrofit请求对象

    @Override
    public void onCreate() {
        super.onCreate();

        App_Gson = new Gson();
        App_Retrofit = new Retrofit.Builder()
                .baseUrl(NetworkConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
