package cn.nam.android.happycloud.dao;

import cn.nam.android.happycloud.service.MyFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class MyFileDaoTest {

    @Resource
    MyFileService myFileService;


    @Test
    public void uploadFileText(){

        int userId = 1000;
        String fileName = "sparkTestData.rar";
        String uploadTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

        System.out.println(uploadTime);

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("O:\\sparkTestData.rar"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean res = myFileService.upLoadFile(inputStream,  userId, fileName, uploadTime);
        System.out.println(res);
    }

}