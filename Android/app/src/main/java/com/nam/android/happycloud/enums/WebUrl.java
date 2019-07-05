package com.nam.android.happycloud.enums;

/**
 * 安卓端访问服务端相关业务url
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public class WebUrl {

    // 电脑连接手机wifi后的IP，短信验证需要使用
        public static final String BASEURL = "http://192.168.43.109:8080/happycloud/";
    // 电脑给手机开热点后的IP
//    public static final String BASEURL = "http://192.168.137.1:8080/happycloud/";
    // 悦
//    public static final String BASEURL = "http://192.168.4.103:8080/happycloud/";

    public static final String SIGNUP = BASEURL + "signup";
    public static final String LOGIN = BASEURL + "login";
    public static final String UPDATENAME = BASEURL + "updatename";
    public static final String UPDATEPHONE = BASEURL + "updatephone";
    public static final String UPDATEPWD = BASEURL + "updatepwd";
    public static final String FORGETPWD = BASEURL + "forgetpwd";
    public static final String SIGNOUT = BASEURL + "signout";
    public static final String UPLOAD = BASEURL + "upload";

}
