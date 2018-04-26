use credit_card;
drop table if exists event;
create table event(
id bigint(100) auto_increment not null comment'ID',
amount numeric(10,2) not null comment '交易额度',
acct varchar(20) not null comment '账户',
card_number char(19) not null comment '信用卡号',
product bigint(100) not null comment'货物ID',
create_time datetime not null default current_timestamp comment'交易产生时间',
primary key(id)
);