package com.cpic.taylor.application.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;

/**
 * Created by Taylor on 2016/5/30.
 */
public class RegisterActivity extends BaseActivity{

    private EditText etMobile,etCode,etPwd,etCarNum,etCarType;
    private Button btnRegister;
    private TextView tvGetCode;

    private Dialog dialog;
    private SharedPreferences sp;

    private int count = 30;

    private TimeCount time;
    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerListener() {

    }
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {// 计时完毕
            tvGetCode.setText("获取验证码");
            tvGetCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            tvGetCode.setClickable(false);// 防止重复点击
            tvGetCode.setText(millisUntilFinished / 1000 + "s" + "重新验证");
        }
    }
}
