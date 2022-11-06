create database demo;
use demo;

create table users(
id int primary key auto_increment,
`name` varchar(50),
email varchar(50),
country varchar(50)
);

insert into users(`name`,email,country) 
values('Truong','changtraitre2000@gmail.com','Da Nang');
insert into users(`name`,email,country) 
values('Dinh','changtraitre1993@gmail.com','Hue');
insert into users(`name`,email,country) 
values('Khoa','changtraitre2003@gmail.com','Da Nang');
insert into users(`name`,email,country) 
values('Hai','changtraitre2003@gmail.com','Da Nang');

select * from users;

DELIMITER //
create procedure get_user_by_id(in user_id int)
begin
    select users.name, users.email, users.country
    from users
    where users.id = user_id;
    end//
DELIMITER ;

DELIMITER $$
create procedure insert_user(
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
    insert into users(name, email, country) values(user_name, user_email, user_country);
    end$$
DELIMITER ;