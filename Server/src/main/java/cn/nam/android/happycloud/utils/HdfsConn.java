package cn.nam.android.happycloud.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;


/**
 * Hadoop 文件系统操作工具类
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public class HdfsConn {

    private FileSystem fileSystem = null;
    private Configuration configuration = null;

    private static class SingletonHolder {
        private static final HdfsConn INSTANCE = new HdfsConn();
    }

    private HdfsConn() {
        try {
            configuration = new Configuration();
            configuration.set("fs.defaultFS", "hdfs://node1:9000/");
            System.setProperty("HADOOP_USER_NAME", "root");
            configuration.set("dfs.permissions", "false");
            fileSystem = FileSystem.get(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileSystem getFileSystem() {
        return SingletonHolder.INSTANCE.fileSystem;
    }

    public static Configuration getConfiguration() {
        return SingletonHolder.INSTANCE.configuration;
    }

}
