package com.zed.ezreal.ezrealzedweather.presenter;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zed.ezreal.ezrealzedweather.model.bean.WeatherLiveBean;
import com.zed.ezreal.ezrealzedweather.model.logic.FutureSevenDaysImp;
import com.zed.ezreal.ezrealzedweather.model.logic.GetWeatherLive;
import com.zed.ezreal.ezrealzedweather.view.main.MainViewInterface;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 该Presenter用来对view的UI变化和model的业务逻辑做处理，
 * 一般来说，该类里面将有model中的逻辑类和view中的Ui类的成员变量，
 * 通过这些实现对应接口类的变量（或者一个实现了MainViewInterface接口的MainActivity.this的成员变量），
 * 来执行UI或者逻辑上的方法。
 * Created by Jiervs on 2016/12/29.
 */
public class MainPresenter {

    private FutureSevenDaysImp fsd;
    private MainViewInterface mvi;
    private GetWeatherLive gwl;
    private Handler mHandler = new Handler();

    /**
     * 参数待定
     */
    public MainPresenter(MainViewInterface mvi) {
        //this.fsd =
        this.mvi = mvi;
        this.gwl = new GetWeatherLive();
    }

    public void getFutureSevenDayData() {

        //得到当前天气的数据,并且展示在UI上
        gwl.getWeatherLiveData(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                try {
                    String s = responseBody.string();
                    mvi.setWeatherLiveInfo(s);
                    Gson gson = new Gson();
                    WeatherLiveBean weatherLiveBean = gson.fromJson(s,WeatherLiveBean.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        //得到数据（现在还是空实现）
        //fsd.getFutureSevenDaysData();
        //Ui线程改变Ui(现在同样是空实现)
        /*mHandler.post(new Runnable() {
            @Override
            public void run() {
                mvi.changeUi();
            }
        });*/
    }
}
