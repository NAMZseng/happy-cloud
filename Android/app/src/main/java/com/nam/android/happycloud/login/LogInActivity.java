package com.nam.android.happycloud.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;



/**
 * 用户登陆界面
 *
 * @author nanrong zeng
 */
@EActivity(R.layout.activity_log_in)
public class LogInActivity extends Activity {
    @ViewById
    EditText phoLoginEt;
    @ViewById
    EditText pwdLoginEt;
    @ViewById
    TextView forgetPwdTv;
    @ViewById
    Button loginBtn;
    @ViewById
    TextView signupTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.forgetPwdTv)
    public void gotoForgetPwd() {
        Intent intentForgetPwd = new Intent(LogInActivity.this, ForgetPwdActivity_.class);
        startActivity(intentForgetPwd);
    }

    @Click(R.id.loginBtn)
    public void gotoMainContent() {
        // TODO 验证手机号与密码
        // 跳转主界面
        Intent intentFileList = new Intent(LogInActivity.this, MainContentActivity.class);
        startActivity(intentFileList);
    }

    @Click(R.id.signupTv)
    public void gotoSignUp() {
        Intent intentSignUp = new Intent(LogInActivity.this, SignUpActivity_.class);
        startActivity(intentSignUp);
    }

}
