create database happycloud;
use happycloud;

-- 用户信息表

create table user_info(
  `user_id` bigint not null auto_increment comment '用户ID',
  `name` varchar(64) comment '用户昵称',
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
  `file_id` bigint not null auto_increment comment '文件ID',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `file_type` varchar(32) not null comment '文件类型，txt,pdf,png,jpg,mp4,mp3...',
  `upload_dir` varchar(64) not null comment '文件上传到网盘的目录',
  `file_state` tinyint not null default 1 comment '文件状态，1：正常，0：放入回收站， -1：彻底清除',
  `upload_time` timestamp not null default current_timestamp comment '文件上传时间',
  `change_time` timestamp not null default current_timestamp comment '文件修改时间',
  primary key(file_id),
  key idx_upload_time(upload_time),
  key idx_change_time(change_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment'用户上传文件信息表';


-- drop table user_download_file;
-- drop table user_share_file;

-- 用户下载文件信息表
create table user_download_file(
  `user_id` bigint not null  comment '用户ID，引用于user_info',
  `file_id` bigint not null  comment '文件ID,引用与user_upload_file',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `file_type` varchar(32) not null comment '文件类型，txt,pdf,png,jpg,mp4,mp3...',
  `download_time` timestamp not null default current_timestamp comment '最近一次的文件下载时间',
  `download_count` int not null default 1 comment '文件下载次数，可用于统计用户感兴趣的文件类型，制作用户活动图表以及文件下载次数统计',
  primary key(user_id, file_id),
  key idx_download_time(download_time)
)engine=innodb default charset=utf8 comment'用户下载文件信息表';

-- 用户分享文件信息
create table user_share_file(
  `user_id` bigint not null  comment '用户ID，引用于user_info',
  `file_id` bigint not null  comment '文件ID,引用与user_upload_file',
  `file_name` varchar(256) not null comment '上传文件的名称',
  `file_type` varchar(32) not null comment '文件类型，txt,pdf,png,jpg,mp4,mp3...',
  `share_time` timestamp not null default current_timestamp comment '最近一次文件分享的时间',
  `share_count` int not null default 1 comment '文件分享次数，可用于统计用户感兴趣的文件类型，制作用户活动图表以及文件下载次数统计',
  primary key(user_id, file_id),
  key idx_share_time(share_time)
)engine=innodb default charset=utf8 comment'用户分享文件信息表';
