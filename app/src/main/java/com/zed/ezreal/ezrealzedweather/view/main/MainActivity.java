package com.zed.ezreal.ezrealzedweather.view.main;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import android.widget.TextView;
import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.presenter.MainPresenter;
import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.view.BaseActivity;

/**
 * Created by Jiervs on 2016/12/29.
 * Fixed by Ezreal on 2017/01/7.
 */

public class MainActivity extends BaseActivity implements MainViewInterface{
    
    MainPresenter mainPresenter;
    TextView textView;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.test);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getFutureSevenDayData();
    }

    @Override
    public void setWeatherLiveInfo(String s) {
        textView.setText(s);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
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
