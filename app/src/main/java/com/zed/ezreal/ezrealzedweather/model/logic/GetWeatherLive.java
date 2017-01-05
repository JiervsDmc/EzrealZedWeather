package com.zed.ezreal.ezrealzedweather.model.logic;

/**
 * 获取未来实时天气信息的实现接口类
 * Created by Jiervs on 2017/1/5.
 */
public class GetWeatherLive implements WeatherLiveImp{

    //该方法的具体实现，将会在MainPresenter中调用该方法得到数据
    @Override
    public void getWeatherLiveData() {
        //这里面是需要做网络请求到数据的逻辑，可以调用网络请求封装框架的方法得到数据，待定
    }
}
