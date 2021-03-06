package com.nam.android.happycloud.start;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.EthiopicCalendar;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.mob.tools.utils.FileUtils;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.entity.OperateInfoDto;
import com.nam.android.happycloud.enums.MsgWhat;
import com.nam.android.happycloud.login.LogInActivity_;
import com.nam.android.happycloud.setting.SettingActivity;
import com.nam.android.happycloud.utils.MyHttpUtil;

import java.io.File;
import java.util.List;

/**
 * 应用主界面，展示用户云盘中的文件
 *
 * @author nanrong zeng
 */
public class MainContentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MyLog";
    private static final int REQUESTCODE_FROM_ACTIVITY = 1000;

    private FloatingActionButton actionUploadFile = null;
    private FloatingActionButton actionNewFloder = null;
    private TextView userNameTv = null;

    private int userId;
    private String phone;
    private String userName;
    private String password;

    private Intent intent = null;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case MsgWhat.UPLOAD:
                    OperateInfoDto result = (OperateInfoDto) msg.obj;
                    if (result.getState().equals(true)) {
                        Toast.makeText(getApplicationContext(), "上传完成", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "上传失败", Toast.LENGTH_LONG).show();
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
        setContentView(R.layout.activity_main_content);

        actionUploadFile = findViewById(R.id.actionUploadFile);
        actionNewFloder = findViewById(R.id.actionNewFloder);

        intent = getIntent();
        userId = Integer.valueOf(intent.getStringExtra("userId"));
        phone = intent.getStringExtra("phone");
        userName = intent.getStringExtra("userName");
        password = intent.getStringExtra("password");

        actionUploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LFilePicker()
                        .withActivity(MainContentActivity.this)
                        .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
                        .start();
            }
        });

        actionNewFloder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 新建文件夹

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        userNameTv = headerView.findViewById(R.id.userName);
        userNameTv.setText(String.valueOf(userName));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUESTCODE_FROM_ACTIVITY) {
                // 获取所选文件绝对路径
                List<String> list = data.getStringArrayListExtra("paths");
                String filePath = list.get(0);
                File file = new File(filePath);
                String uploadTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

                MyHttpUtil.uploadFile(file, userId, uploadTime, handler);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_content, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO 根据输入的query信息显示具体文件

                Toast.makeText(MainContentActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_recently) {
            // TODO 显示用户上传下载文件的类型图表，根据download_count

        } else if (id == R.id.nav_trashbin) {
            // TODO 显示已删除文件

        } else if (id == R.id.nav_setting) {
            // 跳转至设置界面
            Intent intentSetting = new Intent(MainContentActivity.this, SettingActivity.class);

            intentSetting.putExtra("userId", String.valueOf(userId));
            intentSetting.putExtra("phone", phone);
            intentSetting.putExtra("userName", userName);
            intentSetting.putExtra("password", password);

            startActivity(intentSetting);

        } else if (id == R.id.nav_logout) {
            // 弹出确认登出对话框
            new AlertDialog.Builder(this).
                    setTitle("登出")
                    .setMessage("确认退出？")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 返回登录界面
                            Intent intentLogin = new Intent(MainContentActivity.this, LogInActivity_.class);
                            startActivity(intentLogin);
                        }
                    })
                    .create()
                    .show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
