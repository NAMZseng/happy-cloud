package cn.nam.android.happycloud.dao;

import cn.nam.android.happycloud.entity.MyFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件管理Dao
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public interface MyFileDao {

    /**
     * 插入文件上传的记录
     *
     * @param userId
     * @param fileName
     * @param uploadTime
     * @return 更新成功返回1，否则返回0（即sql操作影响的行数）
     */
    int upLoadFile(@Param("user_id") int userId,
                   @Param("file_name") String fileName,
                   @Param("upload_time") String uploadTime);

    List<MyFile> findSUerFiles(@Param("user_id") int userId);
}
