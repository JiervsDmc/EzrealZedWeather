package com.zed.ezreal.ezrealzedweather.model.logic;

/**
 * 获取未来7天天气信息的实现接口类
 * Created by Jiervs on 2016/12/29.
 */
public class GetFutureSevenDays implements FutureSevenDaysImp {

    //该方法的具体实现，将会在MainPresenter中调用该方法得到数据
    @Override
    public void getFutureSevenDaysData() {
        //这里面是需要做网络请求到数据的逻辑，可以调用网络请求封装框架的方法得到数据，待定
    }
}
