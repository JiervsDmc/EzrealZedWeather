package com.zed.ezreal.ezrealzedweather.view.splash;


/**
 * SplashViewInterface接口由MainActivity去实现，包含了SplashActivity作为MVP中view改变UI的抽象方法，
 * 而这些方法在SplashActivity中重写，并由MVP中对应的presenter去执行这些抽象方法。
 * Created by Jiervs on 2016/12/29.
 */
public interface SplashViewInterface {

    void jumpToMain();
}
