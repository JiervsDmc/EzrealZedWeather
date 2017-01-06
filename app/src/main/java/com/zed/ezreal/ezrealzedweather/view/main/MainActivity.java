package com.zed.ezreal.ezrealzedweather.view.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.presenter.MainPresenter;

public class MainActivity extends Activity implements MainViewInterface {

    MainPresenter mainPresenter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.test);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getFutureSevenDayData();
    }

    @Override
    public void setWeatherLiveInfo(String s) {
        textView.setText(s);
    }
}
