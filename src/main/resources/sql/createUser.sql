use credit_card;
drop table if exists user;
create table user(
id bigint(100) not null auto_increment comment 'ID',
acct varchar(20) not null unique comment'账户',
pass_word varchar(20) not null comment'密码',
name nchar(20) comment'用户名',
id_card char(18) comment'身份证号',
point int(10) comment'积分',
amount numeric(10,2) comment'额度',
id_pict varchar(50) comment'照片路径',
create_time datetime default current_timestamp comment'创建时间',
primary key(id));
insert into user(acct,pass_word) values('user1','12345678'),
('user2','12345678'),
('trump','12345678'),
('obama','12345678');