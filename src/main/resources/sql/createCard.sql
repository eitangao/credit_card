use credit_card;
drop table if exists card;
create table card(
card_number char(19) not null comment '信用卡号',
card_amount numeric(10,2)  comment'信用卡额度',
card_point int(10) comment'每张卡的积分',
card_type nchar(20) comment'信用卡类型',
inqpwd varchar(10) not null comment'查询余额时所用密码',
acct varchar(20) not null comment '信用卡绑定的账户',
status varchar(10) not null default 'INACTIVE',
create_time datetime default current_timestamp comment'创建时间',
primary key(card_number));
