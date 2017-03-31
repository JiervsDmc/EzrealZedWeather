package com.zed.ezreal.ezrealzedweather.view.main;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import com.hanks.htextview.base.HTextView;
import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.presenter.MainPresenter;
import com.zed.ezreal.ezrealzedweather.view.BaseActivity;



/**
 * Created by Jiervs on 2016/12/29.
 * Fixed by Ezreal on 2017/01/7.
 */

public class MainActivity extends BaseActivity implements MainViewInterface{
    
    MainPresenter mainPresenter;
    protected TextView textView;
    protected HTextView temperature;//温度
    protected HTextView week;//星期
    protected HTextView city;//城市
    protected ImageView centigrade;//摄氏度dot
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewResId();
        mainPresenter = new MainPresenter(this);
        mainPresenter.getWeatherLiveData("changsha","china");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getViewResId() {
        textView = (TextView) findViewById(R.id.test);

        week = (HTextView) findViewById(R.id.htv_week);
        city = (HTextView) findViewById(R.id.htv_city);
        temperature = (HTextView) findViewById(R.id.htv_temperature);
        centigrade = (ImageView) findViewById(R.id.iv_centigrade);
    }

    @Override
    public void setWeatherLiveInfo(String week,String city,String temperature) {
        this.week.animateText(week);
        this.city.animateText(city);
        this.temperature.animateText(temperature);
        centigrade.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

}
