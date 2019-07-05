package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class user_info extends Model {

//	 `user_id` bigint not null auto_increment comment '用户ID',
//	  `name` varchar(64) default 'friend' comment '用户昵称',
//	  `phone` varchar(20) not null comment '用户登录手机号',
//	  `password` varchar(64) not null comment '用户登录密码',
//	  `create_time` timestamp not null default current_timestamp comment '用户创建时间',
	
	public int user_id;
	public String name;
	public String phone;
	public String password;
	public Date create_time;
	
	public String toString() {
		return name;
	}
}
