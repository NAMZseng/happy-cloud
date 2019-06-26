package com.nam.android.happycloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 用户注册界面
 * @author nanrong zeng
 */
public class SignUpActivity extends Activity {
    private EditText emailSignupEt = null;
    private EditText pwdSignupEt = null;
    private EditText rePwdSignupEt = null;
    private TextView loginTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignupEt = findViewById(R.id.emailSignupEt);
        pwdSignupEt = findViewById(R.id.pwdSignupEt);
        rePwdSignupEt = findViewById(R.id.rePwdSingupEt);

        loginTv = findViewById(R.id.loginTv);
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}
