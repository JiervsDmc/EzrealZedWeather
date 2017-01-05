package com.zed.ezreal.ezrealzedweather.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.zed.ezreal.ezrealzedweather.R;
import com.zed.ezreal.ezrealzedweather.presenter.SplashPresenter;
import com.zed.ezreal.ezrealzedweather.view.BaseActivity;
import com.zed.ezreal.ezrealzedweather.view.main.MainActivity;

/**
 * Created by Jiervs on 2016/12/29.
 */
public class SplashActivity extends BaseActivity implements SplashViewInterface {

    SplashPresenter presenter;
    LinearLayout ll_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll_splash = (LinearLayout) findViewById(R.id.ll_splash);
        presenter = new SplashPresenter(this);
        presenter.jumpToMain();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }


    @Override
    public void jumpToMain() {
        // 设置加载动画透明度渐变从（0.1不显示-1.0完全显示）
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        // 设置动画时间3s
        animation.setDuration(3000);
        // 将组件与动画关联
        ll_splash.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            // 动画开始时执行
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                // 初始化
                init();

            }

            // 动画重复时执行
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            // 动画结束时执行
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void init() {
    }



    @Override
    public void onBackPressed() {
        finish();
    }
}
