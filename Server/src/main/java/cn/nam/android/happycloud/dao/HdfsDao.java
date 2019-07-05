package cn.nam.android.happycloud.dao;

import cn.nam.android.happycloud.utils.HdfsConn;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class HdfsDao {
    private final String basePath = "/happycloud/";

    /**
     * 获得在hdfs中的目录
     *
     * @param userId
     * @param createTime
     * @return
     */
    private String formatUploadPath(String userId, String createTime) {
        return basePath + userId + "/" + createTime;
    }

    /**
     * 上传文件
     *
     * @param inputStream
     * @param userId
     * @param createTime
     */
    public boolean upLoad(InputStream inputStream, String userId, String createTime) {
        try {
            String uploadPath = formatUploadPath(userId, createTime);

            OutputStream outputStream = HdfsConn.getFileSystem().create(new Path(uploadPath), new Progressable() {
                @Override
                public void progress() {
                    System.out.println("upload OK");
                }
            });

            IOUtils.copyBytes(inputStream, outputStream, 2048, true);

            return true;

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 下载文件
     *
     * @param userId
     * @param createTime
     * @param downPath
     * @return
     */
    public boolean download(String userId, String createTime, String downPath) {
        try {
            String formatPath = formatUploadPath(userId, createTime);

            if (HdfsConn.getFileSystem().exists(new Path(formatPath))) {

                FSDataInputStream inputStream = HdfsConn.getFileSystem().open(new Path(formatPath));
                OutputStream outputStream = new FileOutputStream(downPath);

                IOUtils.copyBytes(inputStream, outputStream, 4096, true);

                return true;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 创建文件夹
     *
     * @param userId
     * @param createTime
     */
    public void mkDir(String userId, String createTime) {
        try {
            String formatPath = formatUploadPath(userId, createTime);
            if (!HdfsConn.getFileSystem().exists(new Path(formatPath))) {
                HdfsConn.getFileSystem().mkdirs(new Path(formatPath));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件或目录
     *
     * @param userId
     * @param createTime
     */
    public void delete(String userId, String createTime) {
        try {
            String formatPath = formatUploadPath(userId, createTime);
            if (HdfsConn.getFileSystem().exists(new Path(formatPath))) {
                HdfsConn.getFileSystem().delete(new Path(formatPath), true);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

