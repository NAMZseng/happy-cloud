package cn.nam.android.happycloud.service.impl;


import cn.nam.android.happycloud.dao.UserDao;
import cn.nam.android.happycloud.entity.User;
import cn.nam.android.happycloud.enums.UserLoginDto;
import cn.nam.android.happycloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户相关服务的实现类
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(String phone, String password) {
        User user = userDao.findUser(phone);
        if ( user == null) {
            // 已经注册
            return 0;
        } else {
            int flag = userDao.addUser(phone, password);
            if (flag == 1) {
                // 注册成功
                return 1;
            } else {
                // 注册失败
                return -1;
            }
        }
    }

    @Override
    public UserLoginDto login(String phone, String password) {
        User user = userDao.findUser(phone);
        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误, null表示手机号不匹配
            return  new UserLoginDto(false);
        } else {
            return new UserLoginDto(true, user);
        }
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
