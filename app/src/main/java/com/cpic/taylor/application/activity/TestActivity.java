package com.cpic.taylor.application.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;

/**
 * Created by Taylor on 2016/5/31.
 */
public class TestActivity extends BaseActivity{

    private LinearLayout linearLayout;
    private float mPosX;
    private float mPosY;
    private float mCurrentPosX;
    private float mCurrentPosY;

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
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerListener() {

        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mPosX = motionEvent.getX();
                        mPosY = motionEvent.getY();
                         Log.i("oye", "ACTION_DOWN");
                        break;
                    // 移动
                    case MotionEvent.ACTION_MOVE:
                        Log.i("oye", "ACTION_MOVE");
                        mCurrentPosX = motionEvent.getX();
                        mCurrentPosY = motionEvent.getY();

                        if (mCurrentPosX - mPosX > 20 && Math.abs(mCurrentPosY - mPosY) < 10) {
                            // Log.i("oye", "向右");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                }
                            }, 10);
                        } else if (mCurrentPosX - mPosX < -20 && Math.abs(mCurrentPosY - mPosY) < 10) {
                             Log.i("oye", "向左");

                        } else if (mCurrentPosY - mPosY > 0 && Math.abs(mCurrentPosX - mPosX) < 10) {
                            // Log.i("oye", "向下");
                        } else if (mCurrentPosY - mPosY < 0 && Math.abs(mCurrentPosX - mPosX) < 10) {
                            // Log.i("oye", "向上");
                        }
                        break;
                    // 拿起
                    case MotionEvent.ACTION_UP:
                        Log.i("oye", "ACTION_UP");
                        break;
                    default:
                        break;

                }
                return true;

            }
        });
    }
}
