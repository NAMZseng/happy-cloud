package cn.nam.android.happycloud.service;

import cn.nam.android.happycloud.dao.HdfsDao;
import cn.nam.android.happycloud.dao.MyFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
@Service
public class MyFileService {

    @Autowired
    private MyFileDao myFileDao;

    /**
     * 分别往mysql和HDFS 中插入上传文件信息
     *
     * @param inputStream
     * @param userId
     * @param fileName
     * @param uploadTime
     * @return 成功 true ; 失败 false
     */
    public boolean upLoadFile(InputStream inputStream, int userId, String fileName, String uploadTime) {

        int mysqlResult = myFileDao.upLoadFile(userId, fileName, uploadTime);

        boolean hdfsResult = new HdfsDao().upLoad(inputStream, String.valueOf(userId), uploadTime);

        if (mysqlResult == 1 && hdfsResult) {
            return true;
        } else {
            return false;
        }

    }
}
