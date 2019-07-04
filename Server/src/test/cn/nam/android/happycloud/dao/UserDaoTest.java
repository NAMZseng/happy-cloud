package cn.nam.android.happycloud.dao;

import cn.nam.android.happycloud.dto.UserInfoDto;
import cn.nam.android.happycloud.entity.User;
import cn.nam.android.happycloud.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.nio.cs.US_ASCII;

import javax.annotation.Resource;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserDaoTest {

    @Resource
    private UserService userService;

    @Test
    public void addUserTest(){

        UserInfoDto userInfoDto = userService.signUp("15074798636", "123");
        Gson gson  = new Gson();

        System.out.println(gson.toJson(userInfoDto));

        UserInfoDto userInfoDto1 = gson.fromJson(gson.toJson(userInfoDto), UserInfoDto.class);

        System.out.println(userInfoDto1.getUserId());
    }

}