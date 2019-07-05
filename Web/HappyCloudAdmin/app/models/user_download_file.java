package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class user_download_file extends Model {
	
//	`user_id` bigint not null  comment '用户ID，引用于user_info',
//	  `id` bigint not null auto_increment comment '文件ID,引用与user_upload_file',
//	  `file_name` varchar(256) not null comment '上传文件的名称',
//	  `download_time` timestamp not null default current_timestamp comment '最近一次的文件下载时间',

	  public int user_id;
	  public long id;
	  public String file_name;
	  public Date download_time;	  
	  
	@Override
	public String toString() {
		return file_name;
	}

}
