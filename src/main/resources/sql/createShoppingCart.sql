use credit_card;
drop table if exists shopping_cart;
create table shopping_cart(
id bigint(100) auto_increment,
product_id bigint(100) not null,
product_number int(10) default 1,
acct varchar(20) not null,
create_time datetime default current_timestamp comment'创建时间',
primary key(id));