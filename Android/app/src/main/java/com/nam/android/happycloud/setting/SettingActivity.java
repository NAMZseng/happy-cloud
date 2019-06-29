package com.nam.android.happycloud.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.leon.lib.settingview.LSettingItem;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;

/**
 * 设置界面，提供添加昵称，修改密码，关于应用信息，注销账号等操作
 *
 * @author nanrong zeng
 */
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Toolbar settingToolbar = findViewById(R.id.settingToolbar);
        setSupportActionBar(settingToolbar);

        ImageView settingToolBarBackIV = findViewById(R.id.settingToolBarBackIV);

        LSettingItem settingName = (LSettingItem)findViewById(R.id.settingName);
        LSettingItem settingPhone = (LSettingItem)findViewById(R.id.settingPhone);
        LSettingItem settingPwd = (LSettingItem)findViewById(R.id.settingPwd);
        LSettingItem settingInfo =(LSettingItem) findViewById(R.id.settingInfo);
        LSettingItem settingUnregist = (LSettingItem)findViewById(R.id.settingUnregist);

        settingToolBarBackIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainContentActivity.class);
                startActivity(intent);
            }
        });

        settingName.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO 设置用户昵称
                Toast.makeText(getApplicationContext(), "Hi, Friend", Toast.LENGTH_SHORT).show();
            }
        });

        settingPhone.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO 修改用户登录手机号
            }
        });

        settingPwd.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO 修改登录密码
            }
        });

        settingInfo.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO 显示应用产品信息
            }
        });

        settingUnregist.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO 注销账号
            }
        });
    }

}
