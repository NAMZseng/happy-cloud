package com.nam.android.happycloud.login;

import com.nam.android.happycloud.start.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


/**
 * 用户注册界面，注册成功后跳转至登陆界面
 *
 * @author nanrong zeng
 */
@EActivity(R.layout.activity_sign_up)
public class SignUpActivity extends Activity {
    @ViewById
    EditText phoSignupEt;
    @ViewById
    EditText pwdSignupEt;
    @ViewById
    EditText rePwdSignupEt;
    @ViewById
    Button signupBtn;
    @ViewById
    TextView loginTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.signupBtn)
    public void signUp() {
        boolean isPwdSame = judgePwd();
        String phone = phoSignupEt.getText().toString().trim();
        int phoneLength = 11;

        // TODO 检测密码健壮性,可同judgePWd()一样抽象为公有方法

        if (phone.length() != phoneLength) {
            Toast.makeText(getApplicationContext(), "手机号不正确,请重新输入", Toast.LENGTH_LONG).show();
            phoSignupEt.setText("");
        } else if (!isPwdSame) {
            Toast.makeText(getApplicationContext(), "两次密码不一致，请重新输入", Toast.LENGTH_LONG).show();
            pwdSignupEt.setText("");
            rePwdSignupEt.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_LONG).show();
            // TODO 存入用户信息到数据库
            // 跳转至主界面
            Intent intentFileList = new Intent(SignUpActivity.this, MainContentActivity.class);
            startActivity(intentFileList);
        }
    }

    @Click(R.id.loginTv)
    public void gotoLogIn() {
        Intent intent = new Intent(SignUpActivity.this, LogInActivity_.class);
        startActivity(intent);
    }

    /**
     * 判断两次密码输入是否一致
     * TODO 可抽取该方法
     * @return true: 两次密码输入一致 false:不一致
     */
    public boolean judgePwd() {
        String firstPwd = pwdSignupEt.getText().toString();
        String secondPwd = rePwdSignupEt.getText().toString();

        if ("".equals(firstPwd)) {
            return false;
        }
        if (firstPwd.equals(secondPwd)) {
            return true;
        } else {
            return false;
        }
    }

}
