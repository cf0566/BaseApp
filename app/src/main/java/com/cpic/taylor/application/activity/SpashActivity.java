package com.cpic.taylor.application.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;

/**
 * Created by Taylor on 2016/5/30.
 */
public class SpashActivity extends BaseActivity{
    private LinearLayout rootLayout;
    private static final int sleepTime = 2000;
    private SharedPreferences sp;
    private boolean isFirstIn;

    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_flash);
    }

    @Override
    protected void initView() {
        sp = PreferenceManager.getDefaultSharedPreferences(SpashActivity.this);
        isFirstIn = sp.getBoolean("isFirstIn",true);
    }

    @Override
    protected void initData() {
        rootLayout = (LinearLayout) findViewById(R.id.splash_root);
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(2000);
        rootLayout.startAnimation(animation);
    }

    @Override
    protected void registerListener() {

    }
    @Override
    protected void onStart() {
        super.onStart();

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
                if (isFirstIn){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFirstIn",false);
                    editor.commit();
                    startActivity(new Intent(SpashActivity.this,FirstOpenActivity.class));
                }else {
                    startActivity(new Intent(SpashActivity.this,LoginActivity.class));
                }
                finish();
            }
        }).start();
    }
}
