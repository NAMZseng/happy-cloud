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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/signup")
    public UserInfoDto signUp(@RequestParam("phone") String phone,
                              @RequestParam("password") String password) {

        return userService.signUp(phone, password);
    }

    @RequestMapping(value = "/login")
    public UserInfoDto logIn(@RequestParam("phone") String phone,
                             @RequestParam("password") String password) {

        return userService.logIn(phone, password);
    }

//    @RequestMapping(value = "/updatename")
//    public OperateInfoDto updateUserName(@RequestParam("userId") int userId,
//                                         @RequestParam("newName") String newName) {
//
//        int result = userService.updateUserName(userId, newName);
//
//        OperateInfoDto operateInfoDto = new OperateInfoDto(result+"");
//        return operateInfoDto;
//    }

    @RequestMapping(value = "/updatename")
    public int updateUserName(@RequestParam("userId") int userId,
                              @RequestParam("newName") String newName) {

        return userService.updateUserName(userId, newName);
    }
}