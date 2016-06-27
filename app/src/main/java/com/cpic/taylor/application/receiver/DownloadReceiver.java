package com.cpic.taylor.application.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Taylor on 2016/6/22.
 */
public class DownloadReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())){
            Log.i("oye","电量低，充电");
        }else{
            Log.i("oye","电量可用");
        }
    }
}
