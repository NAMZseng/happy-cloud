package cn.nam.android.happycloud.controller;

/**
 * 用户管理交互模块
 *
 * @author Nanrong Zen/g
 * @version 1.0
 */

import cn.nam.android.happycloud.dto.OperateInfoDto;
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
//    @RequestMapping(value = "/signup")
//    public String signUp(/*@RequestParam("phone") String phone,
//                         @RequestParam("password") String password*/) {
//
//        return "Hello";
//    }

    @RequestMapping(value = "/login")
    public UserInfoDto logIn(@RequestParam("phone") String phone,
                             @RequestParam("password") String password) {

        return userService.logIn(phone, password);
    }

    @RequestMapping(value = "/updatename")
    public OperateInfoDto updateUserName(@RequestParam("userId") int userId,
                                         @RequestParam("newName") String newName) {

        int result = userService.updateUserName(userId, newName);
        OperateInfoDto operateInfoDto = new OperateInfoDto(result + "");
        return operateInfoDto;
    }

    @RequestMapping(value = "/updatephone")
    public OperateInfoDto updatePhone(@RequestParam("password") String password,
                                      @RequestParam("oldPhone") String oldPhone,
                                      @RequestParam("newPhone") String newPhone) {

        int result = userService.updateUserPhone(password, oldPhone, newPhone);
        OperateInfoDto operateInfoDto = new OperateInfoDto(result + "");
        return operateInfoDto;
    }

    @RequestMapping(value = "/updatepwd")
    public OperateInfoDto updatePwd(@RequestParam("phone") String phone,
                                    @RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("newPassword") String newPassword) {

        int result = userService.updateUserPwd(phone, oldPassword, newPassword);
        OperateInfoDto operateInfoDto = new OperateInfoDto(result + "");
        return operateInfoDto;
    }

    @RequestMapping(value = "/forgetpwd")
    public OperateInfoDto forgetPwd(@RequestParam("phone") String phone,
                                    @RequestParam("newPassword") String newPassword) {
        int result = userService.forgetPwd(phone, newPassword);
        OperateInfoDto operateInfoDto = new OperateInfoDto(result + "");
        return operateInfoDto;
    }

    @RequestMapping(value = "/signout")
    public OperateInfoDto signOut(@RequestParam("phone") String phone,
                                  @RequestParam("password") String password) {

        int result = userService.signOut(phone, password);
        OperateInfoDto operateInfoDto = new OperateInfoDto(result + "");
        return operateInfoDto;
    }

}