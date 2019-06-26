package com.nam.android.happycloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 用户登陆界面
 * @author nanrong zeng
 */
public class LogInActivity extends Activity {
    private EditText emailLoginEt = null;
    private EditText pwdLoginEt = null;
    private TextView forgetPwdTv = null;
    private TextView signupTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        emailLoginEt = findViewById(R.id.emailLoginEt);
        pwdLoginEt = findViewById(R.id.pwdLoginEt);
        forgetPwdTv = findViewById(R.id.forgetPwdTv);

        signupTv = findViewById(R.id.signupTv);
        signupTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
