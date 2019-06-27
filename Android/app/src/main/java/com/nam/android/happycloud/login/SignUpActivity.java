package com.nam.android.happycloud.login;

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

/**
 * 用户注册界面，注册成功后跳转至登陆界面
 *
 * @author nanrong zeng
 */
public class SignUpActivity extends Activity implements View.OnClickListener {
    private EditText phoSignupEt = null;
    private EditText pwdSignupEt = null;
    private EditText rePwdSignupEt = null;
    private Button signupBtn = null;
    private TextView loginTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        signupBtn.setOnClickListener(this);
        loginTv.setOnClickListener(this);

    }

    /**
     * 初始化各种控件
     */
    private void init() {

        phoSignupEt = findViewById(R.id.phoSignupEt);
        pwdSignupEt = findViewById(R.id.pwdSignupEt);
        rePwdSignupEt = findViewById(R.id.rePwdSingupEt);
        signupBtn = findViewById(R.id.signupBtn);
        loginTv = findViewById(R.id.loginTv);

    }

    /**
     * 处理各种点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signupBtn:
                boolean isPwdSame = judgePwd();
                String phone = phoSignupEt.getText().toString().trim();
                int phoneLength = 11;
                // TODO 检测密码健壮性,可同judgePWd()一样抽象为公有方法
                if (phone.length() != phoneLength ) {
                    Toast.makeText(getApplicationContext(), "手机号不正确,请重新输入",
                            Toast.LENGTH_LONG).show();
                    phoSignupEt.setText("");
                } else if (!isPwdSame) {
                    Toast.makeText(getApplicationContext(), "两次密码不一致，请重新输入",
                            Toast.LENGTH_LONG).show();
                    pwdSignupEt.setText("");
                    rePwdSignupEt.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "注册成功！",
                            Toast.LENGTH_LONG).show();
                    // TODO 存入用户信息到数据库
                    // 跳转至主界面
                    Intent intentFileList = new Intent(SignUpActivity.this, MainContentActivity.class);
                    startActivity(intentFileList);
                }
                break;
            case R.id.loginTv:
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 判断两次密码输入是否一致
     * // TODO 可抽取该方法
     *
     * @return true: 两次密码输入一致 false:不一致
     */
    private boolean judgePwd() {
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 使用完EventHandler需注销，否则可能出现内存泄漏
    }

}
