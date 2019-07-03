package cn.nam.android.happycloud.controller;

/**
 * 服务端与安卓端交互模块
 *
 * @author Nanrong Zeng
 * @version 1.0
 */

import cn.nam.android.happycloud.dto.UserInfoDto;
import cn.nam.android.happycloud.service.UserService;
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
    @RequestMapping(value= "/regist")
    public UserInfoDto regist(@RequestParam("phone") String phone,
                              @RequestParam("password") String password) {

        return userService.register(phone, password);
    }


}
