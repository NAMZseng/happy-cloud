package cn.nam.android.happycloud.entity;

import java.util.Date;

/**
 * 用户信息实体
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public class User {
    private int userId;
    private String name;
    private int phone;
    private String password;
    private Date createTime;


    @Override
    public String toString() {
        return "User{" +
                "UserId=" + userId +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", password=" + password +
                ", createTime=" + createTime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
