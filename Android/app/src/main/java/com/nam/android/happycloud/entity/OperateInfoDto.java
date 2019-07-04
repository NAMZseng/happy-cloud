package com.nam.android.happycloud.entity;

/**
 * 服务器回传客户端更新删除等操作完成信息
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public class OperateInfoDto {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public OperateInfoDto(String state) {
        this.state = state;
    }


}