package com.zed.ezreal.ezrealzedweather.view.main;

/**
 * MainViewInterface接口由MainActivity去实现，包含了MainActivity作为MVP中view改变UI的抽象方法，
 * 而这些方法在MainActivity中重写，并由MVP中对应的present去执行这些抽象方法。
 * Created by Jiervs on 2016/12/29.
 */
public interface MainViewInterface {

    void setWeatherLiveInfo(String s);
}
