use quan_ly_sinh_vien_ss3_bai_tap;

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