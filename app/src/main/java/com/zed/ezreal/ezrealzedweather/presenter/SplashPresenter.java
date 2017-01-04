package com.zed.ezreal.ezrealzedweather.presenter;

import android.os.Handler;

import com.zed.ezreal.ezrealzedweather.view.splash.SplashViewInterface;

/**
 * Created by Jiervs on 2016/12/29.
 */
public class SplashPresenter {

    private SplashViewInterface splashViewInterface;
    private Handler mHandler = new Handler();

    public SplashPresenter(SplashViewInterface splashViewInterface) {
        this.splashViewInterface = splashViewInterface;
    }

    public void jumpToMain() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                splashViewInterface.jumpToMain();
            }
        });
    }
}
