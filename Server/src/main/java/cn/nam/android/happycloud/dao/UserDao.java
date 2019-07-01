package cn.nam.android.happycloud.dao;

import cn.nam.android.happycloud.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息管理DAO
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param phone      用户登录手机号
     * @param password   用户登录密码
     * @return 更新成功返回1，否则返回0（即sql操作影响的行数）
     */
    int addUser(@Param("phone") String phone, @Param("password") String password);

    /**
     * 查询手机号是否一注册
     *
     * @param phone 用户注册的手机号
     * @return 根据手机号查找用户，存在则返回包含用户信息的User对象，否则返回null
     */
    User findUser(@Param("phone") String phone);

    /**
     * 修改用户昵称
     *
     * @param userId 用户ID
     * @param name   新的用户昵称
     * @return 更新成功返回1，否则返回0
     */
    int updateUserName(@Param("userId") int userId, @Param("name") String name);

    /**
     * 修改用户手机号
     *
     * @param oldPhone
     * @param phone 新的手机号
     * @return 更新成功返回1，否则返回0
     */
    int updateUserPhone(@Param("oldPhone") String oldPhone, @Param("phone") String phone);

    /**
     * 修改用户密码
     *
     * @param phone
     * @param password 新的用户密码
     * @return 更新成功返回1，否则返回0
     */
    int updateUserPwd(@Param("phone") String phone, @Param("password") String password);

    /**
     * 删除用户，注销
     *
     * @param phone
     * @return 删除成功返回1，否则返回0
     */
    int deleteUser(@Param("phone") String phone);
}
