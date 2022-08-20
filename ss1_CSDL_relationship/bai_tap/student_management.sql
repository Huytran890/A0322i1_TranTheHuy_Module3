CREATE DATABASE `student_management`;
use  `student_management`;

create table `student`(
`id` int PRIMARY KEY,
`name` varchar(45) ,
`age` int not null,
`country` varchar(45) 
 );
 
 create table `class` (
 `id` int PRIMARY KEY,
 `name` varchar(45)
 );
 
 create table `teacher` (
 `id` int PRIMARY KEY,
 `name` varchar(45),
 -- `age` int not null,
 `ngaysinh` date,
 `country` varchar(45)
 );
drop table `teacher`;
 
drop table `class`;

insert into `class`(`id`,`name`)
values
(1,"lop A0322i1"),
(2,"lop A0522i1"),
(3,"lop A0722i1");

insert into `student`(`id`,`name`,`age`,`country`)
values
(1,"tran the huy",19,"da nang"),
(2,"le nhi khang",20,"da nang"),
(3,"nguyen thi thuy linh",21,"da nang");

insert into `teacher`(`id`,`name`,`ngaysinh`,`country`)
values
-- (1,"tran thi thuy ai",28,"da nang"),
-- (2,"nguyen kim tuan",56,"da nang"),
-- (3,"huynh ba dieu",50,"da nang");
(1,"tran thi thuy ai1","1975-11-22","da nang"),
(2,"tran thi thuy ai2","2002-11-16","da nang");
insert new 

select * from `class`;
select * from `student`;
select * from `teacher`;