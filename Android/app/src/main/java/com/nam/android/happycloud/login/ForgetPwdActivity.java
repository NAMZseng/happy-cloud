package com.nam.android.happycloud.login;

import com.nam.android.happycloud.entity.OperateInfoDto;
import com.nam.android.happycloud.enums.MsgWhat;
import com.nam.android.happycloud.start.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nam.android.happycloud.R;
import com.nam.android.happycloud.start.MainContentActivity;
import com.nam.android.happycloud.utils.MyHttpUtil;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * 用户密码找回界面
 * 通过输入注册的电话号码，获取验证码，核对正确后重新设置密码
 *
 * @author nanrong zeng
 */
@EActivity(R.layout.activity_forget_pwd)
public class ForgetPwdActivity extends Activity {
    @ViewById
    EditText phoForgetEt;
    @ViewById
    EditText mesForgetEt;
    @ViewById
    Button getMesForgetBtn;
    @ViewById
    EditText pwdForgetEt;
    @ViewById
    EditText rePwdForgetEt;
    @ViewById
    Button confirmForgetBtn;

    // 短信密码找回相关Handler处理事件
    private EventHandler eventHandler = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {
            // afterEvent会在子线程被调用，因此如果后续有UI相关操作，需要将数据发送到UI线程
            Message msg = new Message();
            msg.arg1 = event;
            msg.arg2 = result;
            msg.obj = data;
            new Handler(Looper.getMainLooper(), new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            // 完成发送验证码的请求，验证码短信将几秒钟之后送达
                            Toast.makeText(getApplicationContext(), "获取验证码成功，请稍等",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            ((Throwable) data).printStackTrace();
                        }
                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        // 验证码输入正确
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            // 向服务器提交重置密码Post请求
                            String userPhone = phoForgetEt.getText().toString().trim();
                            String userPwd = pwdForgetEt.getText().toString().trim();
                            MyHttpUtil.forgetPwdPost(userPhone, userPwd, pwdHandler);
                        } else {
                            Toast.makeText(getApplicationContext(), "验证码错误，请重新获取",
                                    Toast.LENGTH_LONG).show();
                            mesForgetEt.setText("");
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    return false;
                }
            }).sendMessage(msg);
        }
    };

    // 重置密码请求修改Handler处理事件
    private final Handler pwdHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == MsgWhat.FORGETPWD) {
                OperateInfoDto result = (OperateInfoDto) msg.obj;
                if (result.getState().equals("1")) {
                    Toast.makeText(getApplicationContext(), "密码重置成功！", Toast.LENGTH_LONG).show();

                    // 跳转登录页面
                    Intent intentLogIn = new Intent(ForgetPwdActivity.this, LogInActivity_.class);
                    startActivity(intentLogIn);
                } else if (result.getState().equals("-1")) {
                    Toast.makeText(getApplicationContext(), "手机号未注册！", Toast.LENGTH_LONG).show();
                    phoForgetEt.setText("");
                    mesForgetEt.setText("");
                    pwdForgetEt.setText("");
                    rePwdForgetEt.setText("");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 注册短信回调
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Click(R.id.getMesForgetBtn)
    public void getMessageCode() {
        String phone = phoForgetEt.getText().toString();
        SMSSDK.getVerificationCode("86", phone);
    }

    @Click(R.id.confirmForgetBtn)
    public void confirmNewPwd() {
        boolean isPwdSame = judgePwd();

        // TODO 检测密码健壮性

        // 密码前后输入一致
        if (isPwdSame) {
            // 提交验证码
            SMSSDK.submitVerificationCode("86",
                    phoForgetEt.getText().toString(),
                    mesForgetEt.getText().toString());
        } else {
            Toast.makeText(getApplicationContext(), "两次密码不一致，请重新输入", Toast.LENGTH_LONG).show();
            pwdForgetEt.setText("");
            rePwdForgetEt.setText("");
        }
    }

    public boolean judgePwd() {
        // TODO 可抽取该方法

        String firstPwd = pwdForgetEt.getText().toString();
        String secondPwd = rePwdForgetEt.getText().toString();

        if ("".equals(firstPwd)) {
            return false;
        }
        if (firstPwd.equals(secondPwd)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 使用完EventHandler需注销，否则可能出现内存泄漏
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
