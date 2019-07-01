package cn.nam.android.happycloud.enums;

import cn.nam.android.happycloud.entity.User;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class UserLoginDto {

    /**
     * 手机号与密码是否正确
     */
    private boolean infoCurrect;
    private User user;

    public UserLoginDto(boolean infoCurrect) {
        this.infoCurrect = infoCurrect;
    }

    public UserLoginDto(boolean infoCurrect, User user) {
        this.infoCurrect = infoCurrect;
        this.user = user;
    }
}
