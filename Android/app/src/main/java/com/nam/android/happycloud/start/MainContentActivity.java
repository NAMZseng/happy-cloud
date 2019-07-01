package com.nam.android.happycloud.start;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nam.android.happycloud.R;
import com.nam.android.happycloud.login.LogInActivity_;
import com.nam.android.happycloud.setting.SettingActivity;

/**
 * 应用主界面，展示用户云盘中的文件
 *
 * @author nanrong zeng
 */
public class MainContentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton actionUploadFile = null;
    FloatingActionButton actionNewFloder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        actionUploadFile = findViewById(R.id.actionUploadFile);
        actionNewFloder = findViewById(R.id.actionNewFloder);


        actionUploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 上传文件
                Toast.makeText(getApplicationContext(), "上传文件", Toast.LENGTH_SHORT).show();

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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent intentSetting = new Intent(MainContentActivity.this, SettingActivity.class);
            startActivity(intentSetting);

        } else if (id == R.id.nav_logout) {
            new AlertDialog.Builder(this).
                    setTitle("登出")
                    .setMessage("确认退出登录？")
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
