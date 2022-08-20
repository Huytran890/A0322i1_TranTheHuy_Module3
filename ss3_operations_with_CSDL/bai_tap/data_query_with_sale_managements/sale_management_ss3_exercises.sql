create database quan_ly_ban_hang_ss3_bai_tap;
use quan_ly_ban_hang_ss3_bai_tap;

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(25),
customer_age int
);

create table `order`(
order_id varchar(20) primary key,
customer_id int,
order_date datetime,
order_total_price int,
foreign key (customer_id) references customer(customer_id)
);

create table product(
product_id int primary key,
product_name varchar(25),
product_price bigint
);

create table order_detail(
order_id varchar(20),
product_id int,
order_quanlity int,
primary key(order_id, product_id),
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id)
);

insert into customer
values(1,'The Huy',10);
insert into customer
values(2,'Trang Chau',20);
insert into customer
values(3,'Thanh Hao',50);

insert into `order`(order_id, customer_id, order_date)
values(1,1,'2006-3-21');
insert into `order`(order_id, customer_id, order_date)
values(2,2,'2006-3-23');
insert into `order`(order_id, customer_id, order_date)
values(3,1,'2006-3-16');

insert into product
values(1,'May Giat',3);
insert into product
values(2,'Tu Lanh',5);
insert into product
values(3,'Dieu Hoa',7);
insert into product
values(4,'Quat',1);
insert into product
values(5,'Bep Dien',2);

insert into order_detail
values(1,1,3);
insert into order_detail
values(1,3,7);
insert into order_detail
values(1,4,2);
insert into order_detail
values(2,1,1);
insert into order_detail
values(3,1,8);
insert into order_detail
values(2,5,4);
insert into order_detail
values(2,3,3);

select o.order_id, o.order_date, o.order_total_price
from `order` o;

select c.customer_name, p.product_name, o.order_date
from `order` o inner join customer c on c.customer_id = o.customer_id
inner join order_detail o_d on o.order_id = o_d.order_id
inner join product p on o_d.product_id = p.product_id;

select c.customer_name
from customer c left join `order` o on c.customer_id = o.customer_id
where o.customer_id is null;

select o.order_id, o.order_date, sum((o_d.order_quanlity*p.product_price)) as order_total_price
from `order` o inner join order_detail o_d on o.order_id = o_d.order_id
inner join product p on o_d.product_id = p.product_id
group by o.order_id;