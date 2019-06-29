package com.nam.android.happycloud.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mob.MobSDK;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;

import org.androidannotations.annotations.EActivity;

import cn.smssdk.SMSSDK;

/**
 * 应用启动界面，可自动跳转至登陆注册界面
 * 同时完成应用相关全局库的初始化
 * @author nanrong zeng
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 手机验证SDK
        MobSDK.init(this, "2b84e6d7bcecc", "d8319c87fe9d1361bc23d68e9a6ace19");
        // 在尝试读取通信录时以弹窗提示用户
        SMSSDK.setAskPermisionOnReadContact(true);

        handler = new Handler();
        // 开始界启动1s后自动进入注册界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LogInActivity_.class);
                startActivity(intent);
            }
        }, 1500);

    }
}
