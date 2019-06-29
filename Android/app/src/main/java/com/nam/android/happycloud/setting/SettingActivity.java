package com.nam.android.happycloud.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;


import com.leon.lib.settingview.LSettingItem;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * 设置界面，提供添加昵称，修改密码，关于应用信息，注销账号等操作
 *
 * @author nanrong zeng
 */
@EActivity(R.layout.activity_setting)
public class SettingActivity extends AppCompatActivity {
    @ViewById
    Toolbar settingToolbar;
    @ViewById
    ImageView settingToolBarBackIV;
    @ViewById
    LSettingItem settingName;
    @ViewById
    LSettingItem settingPhone;
    @ViewById
    LSettingItem settingPwd;
    @ViewById
    LSettingItem settingInfo;
    @ViewById
    LSettingItem settingUnregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(settingToolbar);
    }

    /**
     * 返回应用主界面
     */
    @Click(R.id.settingToolBarBackIV)
    public void goBackMainContain() {
        Intent intent = new Intent(SettingActivity.this, MainContentActivity.class);
        startActivity(intent);
    }

    /**
     * 设置修改用户昵称
     */
    @Click(R.id.settingName)
    public void settingName() {
        // TODO
        Toast.makeText(getApplicationContext(), "Hi, Friend", Toast.LENGTH_LONG).show();
    }

    /**
     * 修改用户登录手机号
     */
    @Click(R.id.settingPhone)
    public void settingPhone() {
        // TODO
    }

    /**
     * 修改用户登录密码
     */
    @Click(R.id.settingPwd)
    public void settingPwd() {
        // TODO
    }

    /**
     * 显示应用产品相关信息
     */
    @Click(R.id.settingInfo)
    public void settingInfo() {
        // TODO
    }

    /**
     * 注销账号
     */
    @Click(R.id.settingUnregist)
    public void setSettingUnregist() {
        // TODO

    }


}
