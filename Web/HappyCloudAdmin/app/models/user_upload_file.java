package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class user_upload_file  extends Model{
	
//	  `user_id` bigint not null  comment '用户ID, 引用于user_info',
//	  `id` bigint not null auto_increment comment '文件ID',
//	  `file_name` varchar(256) not null comment '上传文件的名称',
//	  `file_state` tinyint not null default 1 comment '文件状态，1：正常，0：放入回收站， -1：彻底清除',
//	  `upload_time` varchar(64) not null comment'文件上传时间 yyyyMMddHHmmss',
//	  `change_time` varchar(64) not null comment '文件修改时间 yyyyMMddHHmmss',
//	  primary key(id),
//	
	public int user_id;
	public long id;
	public String file_name;
	public int file_state;
	public String upload_time;
	public String change_time;
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return file_name;
		}
}
