package com.cpic.taylor.application.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.cpic.taylor.application.R;

/**
 * Created by Taylor on 2016/6/22.
 */
public class NotificationUtils {

    public void UseNotifiCation(Context context){
        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("正在下载...");
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.app_icon);
        builder.setLargeIcon(bitmap);
        builder.setSmallIcon(R.drawable.app_icon);
        new Thread(){
            int progress = 0;
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress++;
                    builder.setProgress(100,progress,false);
                    if (progress<=100){
                       if (progress == 100){
                           builder.setContentTitle("已完成");
                       }
                        builder.setNumber(progress);
                    }
                    notificationManager.notify(1,builder.build());
                }
            }
        }.start();
    }

}
