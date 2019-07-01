package cn.nam.android.happycloud.service;

import cn.nam.android.happycloud.enums.UserLoginDto;

/**
 *用户信息相关的服务接口
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public interface UserService {

    /**
     * 根据手机号和密码注册新用户
     *
     * @param phone 用户手机号
     * @param password 用户密码
     * @return 1：注册成功，0：已被注册过，-1：注册失败
     */
    int register(String phone, String password);

    /**
     * 用户登录
     *
     * @param phone 用户手机号
     * @param password 用户密码
     * @return 根据手机号密码是否正确，返回相关Dto
     */
    UserLoginDto login(String phone, String password);

    /**
     * 修改用户昵称
     *
     * @param userId 用户ID
     * @param newName 新名称
     * @return 更新成功返回true，否则返回false
     */
    boolean updateUserName(int userId, String newName);

    /**
     * 修改用户手机号
     *
     * @param password 密码
     * @param oldPhone 现有手机号
     * @param newPhone 新手机号
     * @return  1：更新成功，0：信息错误，-1：更新失败
     */
    int updateUserPhone(String password,String oldPhone, String newPhone);

    /**
     * 修改用户密码
     *
     * @param phone 手机号
     * @param oldPassword 现有密码
     * @param newPassword 新密码
     * @return 1：更新成功，0：信息错误，-1：更新失败
     */
    int updateUserPwd(String phone, String oldPassword,String newPassword);

    /**
     * 删除用户，注销
     *
     * // TODO 其他表中的数据也有一起删除
     *
     * @param phone 手机号
     * @param password 密码
     * @return 1：删除成功，0：信息错误，-1：删除失败
     */
    int deleteUser(String phone, String password);

}
