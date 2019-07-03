package cn.nam.android.happycloud.dto;


/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class UserInfoDto {

    /**
     * 用户状态，包括登录时手机号密码是否正确，注册时手机号是否已经注册
     */
    private boolean state;
    private int userId;
    private String name;
    private String phone;
    private String password;
    private long id;

    public UserInfoDto(boolean state, int userId, String name, String phone, String password, long id) {
        this.state = state;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
