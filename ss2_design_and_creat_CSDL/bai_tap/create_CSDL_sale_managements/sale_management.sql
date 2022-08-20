create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table `order`(
order_id varchar(20) primary key,
customer_id int,
order_date datetime,
order_total_price int,
foreign key (customer_id) references customer(customer_id)
);

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(50),
customer_age int
);

create table order_detail(
order_id varchar(20),
product_id int,
order_quanlity int,
primary key(order_id, product_id),
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id)
);

create table product(
product_id int primary key,
product_name varchar(50),
product_price bigint
);

