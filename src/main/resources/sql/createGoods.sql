use credit_card;
drop table if exists goods;
create table goods(
id bigint(100) auto_increment not null comment 'ID',
name varchar(20) not null comment '货物名字',
price numeric(10,2) not null comment '价格',
spoint int(10) not null comment'积分数',
type varchar(20) not null comment'分类',
application varchar(20) comment'适用人群',
count int(10) default 0 comment'销量',
create_time datetime not null default current_timestamp comment'生产日期',
primary key(id)
);