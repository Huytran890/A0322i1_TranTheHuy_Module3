create database products;
use products;

create table `products`(
id_product int primary key,
product_code varchar(20),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);

insert into products 
values 
(1,'F2G1', 'Ferrari 250 GT0 1963', 76.0, 6, 'made in Italia', 'import'),
(2,'AMV', 'Aston Martin Victor', 58.5, 35, 'made in England', 'import'),
(3,'MBB', 'Mulliner Bacalar Bentley', 42.0, 16, 'made in England', 'import'),
(4,'VRL', 'Veneno Roader Lamborghini', 36.7, 62, 'made in Italia', 'import'),
(5,'VP', 'Vinfast President', 25.0, 99, 'made in Vietnam', 'export');

select* from `products`;

create unique index index_products_code on `products`(product_code);

create index index_products_name_price on `products`(product_name,product_price);

explain select * from `products` 
where product_name = 'Vinfast President';

create view view_product as
select product_code, product_name, product_price, product_status from `products`;

select * from view_product;

create or replace view view_product as 
select product_code, product_name, product_price, product_status
from products;

update view_product
set product_name = 'Lambogini aventador VG'
where product_code = 'AMV';

select * from view_product;

drop view view_product;

-- buoc 5 
delimiter // 
create procedure take_all_products()
begin
	select * from `products`;
end //
delimiter ;
call take_all_products;

delimiter //
create procedure insert_new_products(
id int,
product_code varchar(20),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
)
begin
	insert into products 
    value 
	(id, product_code, product_name, product_price, product_amount, product_description, product_status);
end
// DELIMITER ;

call insert_new_products(6, 'MB', 'S450 Maybach', 80.0, 16,'made in Germany', 'import');
select * from products;

DELIMITER //
create procedure edit_products (
id_product int ,
product_code varchar(25),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50))
begin
update `products` as p
set
product_code = product_code,
product_name = product_name,
product_price = product_price,
product_amount = product_amount,
product_description = product_description,
product_status = product_status
where p.id_product = id_product;
end; 
// DELIMITER ;

drop procedure if exists edit_products;
call edit_products(5, 'RRS', 'Rolls-Royce Sweptail', 120.0, 9,'made in England', 'import');

select * from products;
