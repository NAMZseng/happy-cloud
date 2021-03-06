package com.nam.android.happycloud.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.nam.android.happycloud.entity.OperateInfoDto;
import com.nam.android.happycloud.entity.UserInfoDto;
import com.nam.android.happycloud.enums.MsgWhat;
import com.nam.android.happycloud.enums.WebUrl;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class MyHttpUtil {

    private static final String TAG = "MyLog";

    public static void signUpPost(String phone, String password, final Handler handler) {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(WebUrl.SIGNUP)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                UserInfoDto userInfo = gson.fromJson(response.body().string(), UserInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.SIGNUP;
                message.obj = userInfo;
                handler.sendMessage(message);
            }
        });
    }

    public static void logInPost(String phone, String password, final Handler handler) {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(WebUrl.LOGIN)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                UserInfoDto userInfo = gson.fromJson(response.body().string(), UserInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.LOGIN;
                message.obj = userInfo;
                handler.sendMessage(message);
            }
        });
    }

    public static void updateNamePost(int userId, String newName, final Handler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("userId", String.valueOf(userId))
                .add("newName", newName)
                .build();

        final Request request = new Request.Builder()
                .url(WebUrl.UPDATENAME)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                OperateInfoDto operateInfoDto = gson.fromJson(response.body().string(), OperateInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.UPDATENAME;
                message.obj = operateInfoDto;
                handler.sendMessage(message);
            }
        });

    }

    public static void updatePwdPost(String phone, String oldPassword, String newPassword, final Handler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("oldPassword", oldPassword)
                .add("newPassword", newPassword)
                .build();

        final Request request = new Request.Builder()
                .url(WebUrl.UPDATEPWD)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                OperateInfoDto operateInfoDto = gson.fromJson(response.body().string(), OperateInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.UPDATEPWD;
                message.obj = operateInfoDto;
                handler.sendMessage(message);
            }
        });

    }

    public static void forgetPwdPost(String phone, String newPassword, final Handler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("newPassword", newPassword)
                .build();

        final Request request = new Request.Builder()
                .url(WebUrl.FORGETPWD)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                OperateInfoDto operateInfoDto = gson.fromJson(response.body().string(), OperateInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.FORGETPWD;
                message.obj = operateInfoDto;
                handler.sendMessage(message);
            }
        });

    }

    public static void signOutPost(String phone, String password, final Handler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("password", password)
                .build();

        final Request request = new Request.Builder()
                .url(WebUrl.SIGNOUT)
                .post(requestBody)
                .build();

        // 处理Post返回信息
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                OperateInfoDto operateInfoDto = gson.fromJson(response.body().string(), OperateInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.SIGNOUT;
                message.obj = operateInfoDto;
                handler.sendMessage(message);
            }
        });
    }

    public static void uploadFile(final File file, int userId, String uploadTime, final Handler handler) {

        OkHttpClient client = new OkHttpClient();

        RequestBody fileBody = RequestBody.create(
                MediaType.parse("application/octet-stream"), file);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", String.valueOf(userId))
                .addFormDataPart("fileName", file.getName())
                .addFormDataPart("uploadTime", uploadTime)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();

        Request request = new Request.Builder()
                .url(WebUrl.UPLOAD)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: " + file.getName());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
//                Log.i(TAG, "onResponse: "+ response.body().string());
                OperateInfoDto operateInfoDto = gson.fromJson(response.body().string(), OperateInfoDto.class);
                Message message = new Message();
                message.what = MsgWhat.UPLOAD;
                message.obj = operateInfoDto;
                handler.sendMessage(message);
            }
        });
    }
}
