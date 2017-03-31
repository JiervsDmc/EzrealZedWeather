package com.zed.ezreal.ezrealzedweather.model.logic;

import com.zed.ezreal.ezrealzedweather.EZWApplication;
import com.zed.ezreal.ezrealzedweather.network.NetworkConstant;
import com.zed.ezreal.ezrealzedweather.network.WeatherRequest;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * 获取未来实时天气信息的实现接口类
 * Created by Jiervs on 2017/1/5.
 */
public class GetWeatherLive implements WeatherLiveImp{

    private int weekno = 0;

    //该方法的具体实现，将会在MainPresenter中调用该方法得到数据
    @Override
    public void getWeatherLiveData(Callback<ResponseBody> callback,String city,String country) {

        //这里面是需要做网络请求到数据的逻辑，数据处理交换等在Presenter里面做(这里的具体体现在callback的回调上)
        WeatherRequest weatherRequest = EZWApplication.App_Retrofit.create(WeatherRequest.class);
        Call<ResponseBody> call = weatherRequest.getWeatherNow(city, NetworkConstant.Weather_Key,country);
        call.enqueue(callback);
    }

    @Override
    public int getWeekDay(String date) {

        //获取年月日的时间
        try{
            String dateLoc = date.substring(0,date.indexOf(" "));
            String[] dateVec = dateLoc.split("-");
            int year = Integer.parseInt(dateVec[0]);
            int month = Integer.parseInt(dateVec[1]);
            int day = Integer.parseInt(dateVec[2]);

            Calendar cal=Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DAY_OF_MONTH, day);
            weekno = cal.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.println(weekno);
        }catch (Exception e) {

        }
        return weekno;
    }
}
