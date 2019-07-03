package com.nam.android.happycloud.utils;

/**
 * 安卓端访问服务端相关业务url
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public enum WebUrl {
    /**
     * 注册业务url
     */
    REGISTURL("http://192.168.43.109:8080/happycloud/regist"),
    /**
     * 登录业务url
     */
    LOGINURL("http://39.106.214.230:8080/happycloud/login"),
    /**
     * 更新用户名url
     */
    UPDATENAMEURL("http://39.106.214.230:8080/happycloud/updatename"),
    /**
     * 更新手机号url
     */
    UPDATEPHONEURL("http://39.106.214.230:8080/happycloud/updatephone"),
    /**
     * 更新密码url
     */
    UPDATEPWDURL("http://39.106.214.230:8080/happycloud/updatepwd"),
    /**
     * 注销用户url
     */
    UNREGISTURL("http://39.106.214.230:8080/happycloud/unregist");

    private String url;

    WebUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return url;
    }
}
