package com.cpic.taylor.application.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Taylor on 2016/5/27.
 * 获取屏幕的宽高工具类
 */
public class DisplayScreen {

    public static int screenWidth(final Context context){
        int screenWidth;
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        return  screenWidth;
    }
    public static int screenHeight(final Context context){
        int screenHeight;
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenHeight = metrics.heightPixels;

        return  screenHeight;
    }

}
