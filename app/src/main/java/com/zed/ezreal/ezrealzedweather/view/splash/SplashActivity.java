package com.zed.ezreal.ezrealzedweather.view.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.presenter.SplashPresenter;
import com.zed.ezreal.ezrealzedweather.view.main.MainActivity;

/**
 * Created by Jiervs on 2016/12/29.
 */
public class SplashActivity extends Activity implements SplashViewInterface {

    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter = new SplashPresenter(this);
        presenter.jumpToMain();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }
}
