package com.zed.ezreal.ezrealzedweather.view;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by Ezreal on 2017/1/5.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //继承AppCompatActivity时使用
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //继承activity时使用：
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //把设置布局文件的操作交给继承的子类
        setContentView(getLayoutResId());

        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(true);
        }
    }

    /**
     * @return 返回当前Activity布局文件的id
     */
    abstract protected int getLayoutResId();

    /**
     * findViews
     */
    abstract protected void getViewResId();
}
