package cn.nam.android.happycloud.dto;

/**
 * @author Nanrong Zeng
 * @version 1.0
 */
public class MyFileInfoDto {

    private boolean state;
    private int usrID;
    private int id;
    private String fileName;
    private String fileType;
    private String upLoadDIr;
    private int fileState;


    public MyFileInfoDto(boolean state, int usrID, int id, String fileName, String fileType, String upLoadDIr, int fileState) {
        this.state = state;
        this.usrID = usrID;
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.upLoadDIr = upLoadDIr;
        this.fileState = fileState;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getUsrID() {
        return usrID;
    }

    public void setUsrID(int usrID) {
        this.usrID = usrID;
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

    public String getUpLoadDIr() {
        return upLoadDIr;
    }

    public void setUpLoadDIr(String upLoadDIr) {
        this.upLoadDIr = upLoadDIr;
    }

    public int getFileState() {
        return fileState;
    }

    public void setFileState(int fileState) {
        this.fileState = fileState;
    }
}
