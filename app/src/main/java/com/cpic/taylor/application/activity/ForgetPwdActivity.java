package com.cpic.taylor.application.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;
import com.cpic.taylor.application.utils.ProgressDialogHandle;

/**
 * Created by Taylor on 2016/5/31.
 */
public class ForgetPwdActivity extends BaseActivity{

    private Button btnNext;
    private Intent intent;
    private ImageView ivBack;
    private EditText etMobile,etCode,etPwd,etAgain;
    private TextView tvGetCode;
    private Dialog dialog;
    private int count = 30;

    private TimeCount time;
    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_forget_pwd);
    }

    @Override
    protected void initView() {
        btnNext = (Button) findViewById(R.id.activity_forget_btn_next);
        ivBack = (ImageView) findViewById(R.id.activity_forget_iv_back);
        etMobile = (EditText) findViewById(R.id.activity_forget_et_mobile);
        etPwd = (EditText) findViewById(R.id.activity_forget_et_pwd);
        etAgain = (EditText) findViewById(R.id.activity_forget_et_again);
        etCode = (EditText) findViewById(R.id.activity_forget_et_code);
        dialog = ProgressDialogHandle.getProgressDialog(ForgetPwdActivity.this,null);
        tvGetCode = (TextView) findViewById(R.id.activity_forget_tv_getcode);
        time = new TimeCount(60000, 1000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = etMobile.getText().toString();
                if ("".equals(str)) {
                    showLongToast("手机号码不得为空");
                    return;
                }
                if (str.length() != 11) {
                    showLongToast("手机号码格式不正确");
                    return;
                }

                time.start();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etMobile == null || "".equals(etMobile.getText().toString())){
                    showShortToast("手机号码不得为空");
                    return;
                }
                if (etCode == null || "".equals(etCode.getText().toString())){
                    showShortToast("验证码不得为空");
                    return;
                }
                if (etPwd == null || "".equals(etPwd.getText().toString())){
                    showShortToast("密码不得为空");
                    return;
                }
                if (etMobile == null || "".equals(etMobile.getText().toString())){
                    showShortToast("请再次输入密码");
                    return;
                }
                if (etPwd.getText().equals(etAgain.getText().toString())){
                    showShortToast("两次输入的密码不一致");
                    return;
                }

            }
        });
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
