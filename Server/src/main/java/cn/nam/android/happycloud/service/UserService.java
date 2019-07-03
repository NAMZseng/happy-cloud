package cn.nam.android.happycloud.service;


import cn.nam.android.happycloud.dao.UserDao;
import cn.nam.android.happycloud.entity.User;
import cn.nam.android.happycloud.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * 用户相关服务的实现类
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserInfoDto register(String phone, String password) {
        User user = userDao.findUser(phone);
        if ( user != null) {
            // 已经注册
            return new UserInfoDto(false);
        } else {
           long id = Long.parseLong(phone);
            int flag = userDao.addUser(phone, password,id);
            if (flag == 1) {
                User user2 = userDao.findUser(phone);
                return new UserInfoDto(true,
                                    user2.getUserId(),
                                    user2.getName(),
                                    user2.getPhone(),
                                    user2.getPassword(),
                                    user2.getId());
            } else {
                // 注册失败
                return new UserInfoDto(false);
            }
        }
    }

    public UserInfoDto login(String phone, String password) {
        User user = userDao.findUser(phone);
        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误, null表示手机号不匹配
            return  new UserInfoDto(false);
        } else {
            return new UserInfoDto(true,
                                    user.getUserId(),
                                    user.getName(),
                                    user.getPhone(),
                                    user.getPassword(),
                                    user.getId());
        }
    }

    public boolean updateUserName(int userId, String newName) {
        int flag = userDao.updateUserName(userId, newName);
        if(flag == 1) {
            // 更新成功
            return true;
        } else {
            // 更新失败
            return false;
        }
    }

    public int updateUserPhone(String password, String oldPhone, String newPhone) {
        User user = userDao.findUser(oldPhone);
        if (user == null | !user.getPassword().equals(password)){
            // 信息错误
            return 0;
        } else {
            int flag = userDao.updateUserPhone(oldPhone, newPhone);
            if (flag == 1) {
                // 更新成功
                return 1;
            } else {
                // 更新失败
                return -1;
            }
        }
    }

    public int updateUserPwd(String phone, String oldPassword, String newPassword) {
        User user = userDao.findUser(phone);
        if (user  == null | !user.getPassword().equals(oldPassword)) {
            // 信息错误
            return 0;
        } else {
            int flag = userDao.updateUserPwd(phone, newPassword);
            if (flag == 1) {
                // 更新成功
                return 1;
            } else {
                // 更新失败
                return -1;
            }
        }
    }

    public int deleteUser(String phone, String password) {
        User user = userDao.findUser(phone);
        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误
            return 0;
        } else {
            int flag = userDao.deleteUser(phone);
            if (flag == 1) {
                // 更新成功
                return 1;
            } else {
                // 更新失败
                return -1;
            }
        }
    }
}
