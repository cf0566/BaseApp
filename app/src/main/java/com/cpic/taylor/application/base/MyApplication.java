package com.cpic.taylor.application.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication extends Application {
    /**
     * 日志的开关，false：不打印Log；true：打印Log
     */
    public static final boolean isDebug = false;

    /**
     * 全局上下文
     */
    private Context mContext;

    /**
     * 屏幕的宽度
     */
    public static int mDisplayWitdh;

    /**
     * 屏幕的高度
     */
    public static int mDisplayHeight;

    private static final String TAG = "JPush";


    private SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }
}
