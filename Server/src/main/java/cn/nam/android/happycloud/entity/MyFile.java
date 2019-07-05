package cn.nam.android.happycloud.entity;

import java.util.Date;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class MyFile {

    private int userId;
    private int id;
    private String fileName;
    private String fileType;
    private String uploadDir;
    private int fileState;
    private Date uploadTime;
    private Date changeTime;

    @Override
    public String toString() {
        return "MyFile{" +
                "UserId=" + userId +
                ", FileId='" + id + '\'' +
                ", fileName=" + fileName +
                ", fileType=" + fileType +
                ", uploadDir=" + uploadDir +
                ", fileState=" + fileState +
                ", uploadTime=" + uploadTime +
                ", changeTime=" + changeTime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public int getFileState() {
        return fileState;
    }

    public void setFileState(int fileState) {
        this.fileState = fileState;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
}
