package com.zed.ezreal.ezrealzedweather.presenter;

import android.content.Intent;
import android.os.Handler;

import com.zed.ezreal.ezrealzedweather.view.main.MainActivity;
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
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            splashViewInterface.jumpToMain();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
