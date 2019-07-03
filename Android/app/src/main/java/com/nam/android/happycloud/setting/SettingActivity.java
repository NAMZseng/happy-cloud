package com.nam.android.happycloud.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.leon.lib.settingview.LSettingItem;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.login.LogInActivity_;
import com.nam.android.happycloud.login.SignUpActivity_;
import com.nam.android.happycloud.start.MainContentActivity;

import org.androidannotations.annotations.ViewById;

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
                View view = LayoutInflater.from(SettingActivity.this)
                                .inflate(R.layout.update_name_item, null);
                final EditText nameEt = view.findViewById(R.id.settingNameItm);
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);

                builder.setTitle("设置昵称");

                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String name = nameEt.getText().toString().trim();
                        // TODO POST设置昵称操作到服务端

                        Toast.makeText(getApplicationContext(), "修改成功！", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });

                builder.create();
                builder.show();
            }
        });

        settingPhone.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                View view = LayoutInflater.from(SettingActivity.this)
                        .inflate(R.layout.update_phone_item, null);

                final EditText oldPhoneEt = findViewById(R.id.settingOldPhoneItm);
                final EditText PhoPasswordEt = findViewById(R.id.settingPhonePwdItm);
                final EditText newPhoneEt = findViewById(R.id.settingNewPhoneItm);

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);

                builder.setTitle("修改手机号");

                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        String oldPhone = oldPhoneEt.getText().toString().trim();
//                        String password = PhoPasswordEt.getText().toString().trim();
//                        String newPhone = newPhoneEt.getText().toString().trim();

                        // TODO POST修改手机操作到服务端

//                        Toast.makeText(getApplicationContext(), "修改成功，请重新登录！", Toast.LENGTH_LONG).show();
                        Intent rePhoneIntent = new Intent(SettingActivity.this, LogInActivity_.class);
                        startActivity(rePhoneIntent);

                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });

                builder.create();
                builder.show();
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
                View view = LayoutInflater.from(SettingActivity.this)
                        .inflate(R.layout.about_item, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("关于");
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                builder.create();
                builder.show();

            }
        });

        settingUnregist.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                new AlertDialog.Builder(SettingActivity.this).
                        setTitle("注销")
                        .setMessage("确认注销账号？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO  // TODO POST注销操作到服务端

                                // 返回注册界面
                                Intent intentLogin = new Intent(SettingActivity.this, SignUpActivity_.class);
                                startActivity(intentLogin);
                            }
                        })
                        .create()
                        .show();

                // TODO 注销账号
            }
        });
    }

}
