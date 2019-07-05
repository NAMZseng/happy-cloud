package cn.nam.android.happycloud.controller;

import cn.nam.android.happycloud.dto.OperateInfoDto;
import cn.nam.android.happycloud.service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 文件管理交互模块
 *
 * @author Nanrong Zeng
 * @version 1.0
 */

@RestController
@RequestMapping("/happycloud")
public class MyFileController {

    @Autowired
    MyFileService myFileService;

    /**
     * 文件上传模块
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload")
    public OperateInfoDto upload(final HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userId = request.getParameter("userId");
        String fileName = request.getParameter("fileName");
        String uploadTime = request.getParameter("uploadTime");

        InputStream inputStream = request.getInputStream();

        boolean resultBoolean = myFileService.upLoadFile(inputStream, Integer.valueOf(userId), fileName, uploadTime);
        OperateInfoDto result = new OperateInfoDto(String.valueOf(resultBoolean));
        return  result;

    }

}
