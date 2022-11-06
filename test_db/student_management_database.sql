create database quan_ly_sinh_vien_ss3_bai_tap;
use quan_ly_sinh_vien_ss3_bai_tap;

create table class(
class_id int primary key auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit
);

create table student(
student_id int primary key auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references class(class_id)
);

create table `subject`(
sub_id int primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint default 1 check (credit >=1),
`status` bit default 1
);

create table mark(
mark_id int primary key auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
unique (sub_id,student_id),
foreign key (sub_id) references `subject`(sub_id),
foreign key (student_id) references student(student_id)
);

insert into class
values (1, 'A1', '2008-12-20', 1);
insert into class
values (2, 'A2', '2008-12-22', 1);
insert into class
values (3, 'B3', current_date, 0);

insert into student (student_name, address, phone, `status`, class_id)
values ('Hung', 'Ha Noi', '0905783653', 1, 1);
insert into student (student_name, address, `status`, class_id)
values ('Huy', 'Da nang', 1, 1);
insert into student (student_name, address, phone, `status`, class_id)
values ('Chau', 'HCM', '0916499908', 0, 2);

insert into `subject`
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

insert into mark (sub_id, student_id, mark, exam_times)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
select*
from student;

select*
from student
where `status` = true;

select*
from `subject`
where credit < 10;

select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id;

select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id
where c.class_name = 'A1';

select s.student_id, s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id 
join `subject` sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';

select *
from student
where student.student_name like 'h%';

select *
from class
where month(start_date)=12;

select *
from `subject`
where (credit >=3) and (credit<=5);

SET SQL_SAFE_UPDATES = 0;
update student
set class_id = 2
where student_name = 'hung';

select * 
from student
where student_id = 1;

select student.student_name, `subject`.sub_name, mark.mark
from student, `subject`, mark
order by mark.mark asc,
student_name asc;

select *
from `subject` s
where s.credit = (select max(credit) from `subject`);

select s.sub_id, s.sub_name, m.mark, s.`status`
from `subject` s inner join mark m on s.sub_id = m.sub_id
where m.mark = (select max(mark) from mark);

select s.student_id, s.student_name, s.`status`,s.class_id, avg(m.mark) as mark
from student s inner join mark m on s.student_id = m.student_id
group by s.student_id
order by m.mark desc;