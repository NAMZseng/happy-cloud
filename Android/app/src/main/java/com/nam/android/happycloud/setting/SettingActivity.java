package com.nam.android.happycloud.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.nam.android.happycloud.entity.OperateInfoDto;
import com.nam.android.happycloud.enums.MsgWhat;
import com.nam.android.happycloud.login.LogInActivity_;
import com.nam.android.happycloud.login.SignUpActivity_;
import com.nam.android.happycloud.start.MainContentActivity;
import com.nam.android.happycloud.utils.MyHttpUtil;

/**
 * 设置界面，提供添加昵称，修改密码，关于应用信息，注销账号等操作
 *
 * @author nanrong zeng
 */
public class SettingActivity extends AppCompatActivity {

    private static final String TAG = "MyLog";

    private int userId;
    private String phone;
    private String userName;
    private String password;

    private Intent intent = null;

    final Handler settingHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MsgWhat.UPDATENAME:
                    // 设置昵称
                    OperateInfoDto updateResult = (OperateInfoDto) msg.obj;
                    if (updateResult.getState().equals("1")) {
                        Toast.makeText(getApplicationContext(), "昵称设置成功！", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, 设置失败！", Toast.LENGTH_LONG).show();
                    }
                    break;
                case MsgWhat.UPDATEPHONE:
                    // 修改手机号
                    break;
                case MsgWhat.UPDATEPWD:
                    // 修改密码
                    break;
                case MsgWhat.SIGNOUT:
                    // 注销账号
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar settingToolbar = findViewById(R.id.settingToolbar);
        setSupportActionBar(settingToolbar);

        ImageView settingToolBarBackIV = findViewById(R.id.settingToolBarBackIV);

        LSettingItem settingName = (LSettingItem) findViewById(R.id.settingName);
        LSettingItem settingPhone = (LSettingItem) findViewById(R.id.settingPhone);
        LSettingItem settingPwd = (LSettingItem) findViewById(R.id.settingPwd);
        LSettingItem settingInfo = (LSettingItem) findViewById(R.id.settingInfo);
        LSettingItem settingUnregist = (LSettingItem) findViewById(R.id.settingUnregist);

        intent = getIntent();
        userId = Integer.valueOf(intent.getStringExtra("userId"));
        phone = intent.getStringExtra("phone");
        userName = intent.getStringExtra("userName");
        password = intent.getStringExtra("password");

        // 返回主界面
        settingToolBarBackIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(SettingActivity.this, MainContentActivity.class);

                intentBack.putExtra("userId", String.valueOf(userId));
                intentBack.putExtra("phone", phone);
                intentBack.putExtra("userName", userName);
                intentBack.putExtra("password", password);

                startActivity(intentBack);
            }
        });

        // 设置昵称
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

                        String newName = nameEt.getText().toString().trim();
                        userId = Integer.parseInt(intent.getStringExtra("userId"));

                        MyHttpUtil.updateNamePost(userId, newName, settingHandler);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create();
                builder.show();
            }
        });

        // 修改电话
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

                        // TODO POST修改手机操作到服务端

                        Intent rePhoneIntent = new Intent(SettingActivity.this, LogInActivity_.class);
                        startActivity(rePhoneIntent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create();
                builder.show();
            }
        });

        settingPwd.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                // TODO POST修改密码操作到服务端
            }
        });

        // 显示应用信息
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

        // 注销
        settingUnregist.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                new AlertDialog.Builder(SettingActivity.this).
                        setTitle("注销")
                        .setMessage("确认注销账号？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO POST注销操作到服务端

                                // 返回注册界面
                                Intent intentLogin = new Intent(SettingActivity.this, SignUpActivity_.class);
                                startActivity(intentLogin);
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

}
