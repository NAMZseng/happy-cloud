-- create database happycloud;
use happycloud;

drop database happycloud;

-- 用户信息表
create table user_info(
  `user_id` bigint not null auto_increment comment '用户ID',
  `name` varchar(64) default 'friend' comment '用户昵称',
  `phone` varchar(20) not null comment '用户登录手机号',
  `password` varchar(64) not null comment '用户登录密码',
  `create_time` timestamp not null default current_timestamp comment '用户创建时间',
  primary key(user_id),
  key idx_create_time(create_time),
  key idx_phone(phone)
)engine=innodb auto_increment=1000 default charset=utf8 comment'用户信息表';

--INSERT INTO user_info(name, phone, password) VALUES ('曾楠嵘', '15074798636', '123');

-- 用户上传文件信息表
create  table user_upload_file(
  `user_id` bigint not null  comment '用户ID, 引用于user_info',
  `id` bigint not null auto_increment comment '文件ID',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `file_state` tinyint not null default 1 comment '文件状态，1：正常，0：放入回收站， -1：彻底清除',
  `upload_time` varchar(64) not null comment'文件上传时间 yyyyMMddHHmmss',
  `change_time` varchar(64) not null comment '文件修改时间 yyyyMMddHHmmss',
  primary key(id),
  key idx_upload_time(upload_time),
  key idx_change_time(change_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment'用户上传文件信息表';


-- 用户下载文件信息表
create table user_download_file(
  `user_id` bigint not null  comment '用户ID，引用于user_info',
  `id` bigint not null auto_increment comment '文件ID,引用与user_upload_file',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `download_time` timestamp not null default current_timestamp comment '最近一次的文件下载时间',
  primary key(id),
  key idx_download_time(download_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment'用户下载文件信息表';

-- 用户分享文件信息
create table user_share_file(
  `user_id` bigint not null  comment '用户ID，引用于user_info',
  `id` bigint not null auto_increment comment '文件ID,引用与user_upload_file',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `share_time` timestamp not null default current_timestamp comment '最近一次文件分享的时间',
  primary key(id),
  key idx_share_time(share_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment'用户分享文件信息表';
