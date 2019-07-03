package com.nam.android.happycloud.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nam.android.happycloud.R;
import com.nam.android.happycloud.entity.UserInfoDto;
import com.nam.android.happycloud.enums.MsgWhat;
import com.nam.android.happycloud.start.MainContentActivity;
import com.nam.android.happycloud.utils.MyHttpUtil;

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

    Handler logInHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case MsgWhat.LOGIN:
                    UserInfoDto userInfoDto = (UserInfoDto) msg.obj;
                    if (userInfoDto.isState() == false) {
                        // 手机号为注册
                        Toast.makeText(getApplicationContext(), "手机号未注册！", Toast.LENGTH_LONG).show();
                        phoLoginEt.setText("");
                        pwdLoginEt.setText("");
                    } else {
                        Intent intentLogin = new Intent(LogInActivity.this, MainContentActivity.class);

                        intentLogin.putExtra("userId", userInfoDto.getUserId());
                        intentLogin.putExtra("phone", userInfoDto.getPhone());
                        intentLogin.putExtra("userName", userInfoDto.getName());
                        intentLogin.putExtra("password", userInfoDto.getPassword());

                        startActivity(intentLogin);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 跳转忘记密码界面
     */
    @Click(R.id.forgetPwdTv)
    public void gotoForgetPwd() {
        Intent intentForgetPwd = new Intent(LogInActivity.this, ForgetPwdActivity_.class);
        startActivity(intentForgetPwd);
    }

    /**
     * 登录成功， 跳转用户主页面
     */
    @Click(R.id.loginBtn)
    public void logIn() {

        String phone = phoLoginEt.getText().toString().trim();
        String password = pwdLoginEt.getText().toString().trim();
        int phoneLength = 11;

        if (phone.length() != phoneLength) {
            Toast.makeText(getApplicationContext(), "手机号不正确,请重新输入", Toast.LENGTH_LONG).show();
            phoLoginEt.setText("");
        } else {
            // 提交登录请求
            new MyHttpUtil().logInPost(phone, password, logInHandler);
        }
    }

    /**
     * 跳转注册页面
     */
    @Click(R.id.signupTv)
    public void gotoSignUp() {
        Intent intentSignUp = new Intent(LogInActivity.this, SignUpActivity_.class);
        startActivity(intentSignUp);
    }

}
