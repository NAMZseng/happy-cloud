package cn.nam.android.happycloud.controller;

/**
 * 服务端与安卓端交互模块
 *
 * @author Nanrong Zeng
 * @version 1.0
 */

import cn.nam.android.happycloud.dto.UserInfoDto;
import cn.nam.android.happycloud.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/happycloud")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册模块
     *
     * @param phone
     * @param password
     */
    @RequestMapping(value= "/signup")
    public String signUp(@RequestParam("phone") String phone,
                              @RequestParam("password") String password) {

        UserInfoDto userInfoDto  = userService.signUp(phone, password);

        Gson gson  = new Gson();
        return gson.toJson(userInfoDto);
    }

    @RequestMapping(value = "/login")
    public String logIn(@RequestParam("phone") String phone,
                         @RequestParam("password") String password) {

        UserInfoDto userInfoDto = userService.logIn(phone, password);

        Gson gson = new Gson();
        return gson.toJson(userInfoDto);
    }

    @RequestMapping(value = "/updatename")
    public String updateUserName(@RequestParam("userId") int userId,
                                 @RequestParam("newName") String newName) {

        boolean result = userService.updateUserName(userId, newName);

        Gson gson = new Gson();
        return gson.toJson(result);
    }
}