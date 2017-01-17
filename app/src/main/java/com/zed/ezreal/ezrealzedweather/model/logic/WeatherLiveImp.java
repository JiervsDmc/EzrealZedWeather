package com.zed.ezreal.ezrealzedweather.model.logic;


import okhttp3.ResponseBody;
import retrofit2.Callback;

/**
 * Created by wangjie01 on 2017/1/5.
 */
public interface WeatherLiveImp {

    void getWeatherLiveData(Callback<ResponseBody> callback);
}
