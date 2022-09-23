create database `user`;
use `user`;

create table users (
id int primary key auto_increment,
`name` varchar(50) NOT NULL,
email varchar(50) NOT NULL,
country varchar(100)
);

insert into users(`name`,email, country)
values('Huy', 'huytran161122@gmail.com', 'Da Nang');
insert into users(`name`,email,country) 
values('Khang','khang123@gmail.com','Phu Yen');
insert into users(`name`,email,country) 
values('Nhan','thanhnhan123@gmail.com','Hue');