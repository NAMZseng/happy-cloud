package com.nam.android.happycloud.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nam.android.happycloud.R;

/**
 * 用户登陆界面
 *
 * @author nanrong zeng
 */
public class LogInActivity extends Activity implements View.OnClickListener {
    private EditText phoLoginEt = null;
    private EditText pwdLoginEt = null;
    private TextView forgetPwdTv = null;
    private Button loginBtn = null;
    private TextView signupTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        phoLoginEt = findViewById(R.id.phoLoginEt);
        pwdLoginEt = findViewById(R.id.pwdLoginEt);
        forgetPwdTv = findViewById(R.id.forgetPwdTv);
        loginBtn = findViewById(R.id.loginBtn);
        signupTv = findViewById(R.id.signupTv);

        forgetPwdTv.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        signupTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgetPwdTv:
                Intent intentForgetPwd = new Intent(LogInActivity.this, ForgetPwdActivity.class);
                startActivity(intentForgetPwd);
                break;
            case R.id.loginBtn:
                // TODO 跳转主界面
                break;
            case R.id.signupTv:
                Intent intentSignUp = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);
                break;
            default:
                break;
        }
    }
}
