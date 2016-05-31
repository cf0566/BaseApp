package com.cpic.taylor.application.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;
import com.cpic.taylor.application.utils.ProgressDialogHandle;

/**
 * Created by Taylor on 2016/5/30.
 */
public class LoginActivity extends BaseActivity{

    private TextView tvForget;
    private Intent intent;
    private TextView tvRegister;
    private Button btnLogin;
    private Dialog dialog;
    private EditText etName, etPwd;
    private SharedPreferences sp;

    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        tvForget = (TextView) findViewById(R.id.activity_login_tv_forget);
        tvRegister = (TextView) findViewById(R.id.activity_login_tv_register);
        btnLogin = (Button) findViewById(R.id.activity_login_btn_login);
        etName = (EditText) findViewById(R.id.activity_login_et_name);
        etPwd = (EditText) findViewById(R.id.activity_login_et_pwd);
        dialog = ProgressDialogHandle.getProgressDialog(LoginActivity.this, null);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerListener() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (etName.getText().toString() == null || etPwd.getText().toString() == null
//                        || "".equals(etName.getText().toString()) || "".equals(etPwd.getText().toString())) {
//                    showShortToast("用户名和密码不得为空");
//                    return;
//                }
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ForgetPwdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        sp = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        etName.setText(sp.getString("mobile", ""));
        etPwd.setText(sp.getString("pwd", ""));
    }
}
