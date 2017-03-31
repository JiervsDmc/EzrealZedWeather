package com.zed.ezreal.ezrealzedweather.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jiervs on 2017/1/5.
 */
public interface WeatherRequest {

    /**
     * 查询当前city的实时天气信息
     * @param city
     * @param key
     * @param lang
     * @return
     */
    @GET("now")
    Call<ResponseBody> getWeatherNow(@Query("city") String city,
                                     @Query("key") String key,
                                     @Query("lang") String lang);

}
