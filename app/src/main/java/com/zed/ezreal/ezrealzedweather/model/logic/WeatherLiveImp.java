package com.zed.ezreal.ezrealzedweather.model.logic;


import okhttp3.ResponseBody;
import retrofit2.Callback;

/**
 * Created by Jiervs on 2017/1/5.
 */
public interface WeatherLiveImp {
    /**
     * 请求即时天气now方法
     * @param callback
     * @param city
     * @param country
     */
    void getWeatherLiveData(Callback<ResponseBody> callback,String city,String country);

    /**
     * 根据日历得到星期
     * @param date
     * @return
     */
    int getWeekDay(String date);
}
