package cn.nam.android.happycloud.web;

/**
 * 服务端与安卓端交互模块
 *
 * @author Nanrong Zeng
 * @version 1.0
 */

import cn.nam.android.happycloud.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.Map;

@Controller("UserController")
@RequestMapping("/happycloud")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 注册模块
     *
     * @param request
     * @param json
     * @return 1：注册成功，0：已被注册过，-1：注册失败
     */
    @ResponseBody
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String regist(HttpServletRequest request, @RequestBody String json) {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> userInfoMap = gson.fromJson(json, mapType);

        String phone = userInfoMap.get("phone");
        String password = userInfoMap.get("password");

        int result = userService.register(phone, password);

        return String.valueOf(result);
    }

}
