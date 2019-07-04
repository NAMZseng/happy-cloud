package cn.nam.android.happycloud.service;


import cn.nam.android.happycloud.dao.UserDao;
import cn.nam.android.happycloud.dto.UserInfoDto;
import cn.nam.android.happycloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 注册服务
     *
     * @param phone
     * @param password
     * @return
     */
    public UserInfoDto signUp(String phone, String password) {
        User user = userDao.findUser(phone);

        if (user != null) {
            // 已经注册
            return new UserInfoDto(false, -1, "-1", "-1", "-1", -1);
        } else {
            long id = Long.parseLong(phone);
            int flag = userDao.addUser(phone, password, id);
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
                return new UserInfoDto(false, -1, "-1", "-1", "-1", -1);
            }
        }
    }

    /**
     * 登录业务
     *
     * @param phone
     * @param password
     * @return
     */
    public UserInfoDto logIn(String phone, String password) {
        User user = userDao.findUser(phone);

        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误, null表示手机号不匹配
            return new UserInfoDto(false, -1, "-1", "-1", "-1", -1);
        } else {
            return new UserInfoDto(true,
                    user.getUserId(),
                    user.getName(),
                    user.getPhone(),
                    user.getPassword(),
                    user.getId());
        }
    }

    /**
     * 修改用户昵称
     *
     * @param userId
     * @param newName
     * @return 1 成功， 0 失败
     */
    public int updateUserName(int userId, String newName) {
        return userDao.updateUserName(userId, newName);
    }

    /**
     * 更新用户手机号
     *
     * @param password
     * @param oldPhone
     * @param newPhone
     * @return -1 手机号密码不匹配，1 更新成功， 0 更新失败
     */
    public int updateUserPhone(String password, String oldPhone, String newPhone) {
        User user = userDao.findUser(oldPhone);
        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误
            return -1;
        } else {
            return userDao.updateUserPhone(oldPhone, newPhone);
        }
    }

    /**
     * 更新用户密码
     *
     * @param phone
     * @param oldPassword
     * @param newPassword
     * @return -1 手机号密码不匹配，1 更新成功， 0 更新失败
     */
    public int updateUserPwd(String phone, String oldPassword, String newPassword) {
        User user = userDao.findUser(phone);
        if (user == null | !user.getPassword().equals(oldPassword)) {
            // 信息错误
            return -1;
        } else {
            return userDao.updateUserPwd(phone, newPassword);
        }
    }

    /**
     * 注销用户
     *
     * @param password
     * @param oldPhone
     * @param newPhone
     * @return -1 手机号密码不匹配，1 删除成功， 0 删除失败
     */
    public int signOut(String phone, String password) {
        User user = userDao.findUser(phone);
        if (user == null | !user.getPassword().equals(password)) {
            // 信息错误
            return -1;
        } else {
            // TODO 删除 file相关表的所有信息
            return userDao.deleteUser(phone);
        }
    }
}
