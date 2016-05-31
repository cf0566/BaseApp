package com.cpic.taylor.application.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.Service.LoadSerVice;
import com.cpic.taylor.application.base.BaseActivity;

/**
 * Created by Taylor on 2016/5/31.
 */
public class TestActivity extends BaseActivity{

    private LinearLayout linearLayout;
    private Button btn1,btn2,btn3;
    private LoadSerVice.MyBinder binder;
    private boolean isBound = false;

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
            isBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (LoadSerVice.MyBinder) service;
        }
    };

    @Override
    protected void getIntentData(Bundle savedInstanceState) {
    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_test);
    }

    @Override
    protected void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void registerListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isBound) {
                    Intent intent = new Intent(TestActivity.this, LoadSerVice.class);
                    bindService(intent, conn, BIND_AUTO_CREATE);
                    isBound = true;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binder != null) {
                    binder.pause();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound) {
                    binder.resume();
                }
            }
        });


    }
}
