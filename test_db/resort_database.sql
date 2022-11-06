create database furama_resort;
use furama_resort;

create table vi_tri(
ma_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45)
);

create table trinh_do(
ma_trinh_do int auto_increment primary key,
ten_trinh_do varchar(45)
);

create table bo_phan(
ma_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);

create table nhan_vien(
ma_nhan_vien int auto_increment primary key,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table loai_khach(
ma_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45)
);


create table khach_hang(
ma_khach_hang int auto_increment primary key,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit default 1 not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int not null,
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table loai_dich_vu(
ma_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
ma_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45)
);

create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45) not null,
dien_tich int,
chi_phi_thue double not null,
so_nguoi_toi_da int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int,
ma_dich_vu int not null,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang) on delete set null,
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45) not null,
gia double not null,
don_vi varchar(10) not null,
trang_thai varchar(45)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
so_luong int not null,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

-- TASK 1

insert into vi_tri
values (1,"Quản lí");
insert into vi_tri
values (2,"Nhân viên");

insert into trinh_do
values (1,"Trung cấp");
insert into trinh_do
values (2,"Cao đẳng");
insert into trinh_do
values (3,"Đại học");
insert into trinh_do
values (4,"Sau đại học");

insert into bo_phan
values (1,"Sale - Marketing");
insert into bo_phan
values (2,"Hành chính");
insert into bo_phan
values (3,"Phục vụ");
insert into bo_phan
values (4,"Quản lý");

insert into nhan_vien
values(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,
'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành ,Đà Nẵng',1,3,1);
insert into nhan_vien
values(2,'Lê Văn Bình','1997-04-09','654231234',7000000,
'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2);
insert into nhan_vien
values(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,
'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2);
insert into nhan_vien
values(4,'Võ Công Toản','1980-04-04','123231365',17000000,
'0374443232','toan0404@gmail.com','77 Hoàng Diệu,Quảng Trị',1,4,4);
insert into nhan_vien
values(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,
'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1);
insert into nhan_vien
values(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,
'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3);
insert into nhan_vien
values(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,
'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2);
insert into nhan_vien
values(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,
'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4);
insert into nhan_vien
values(9,'Tòng Hoang','1982-09-03','256781231',6000000,
'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4);
insert into nhan_vien
values(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,
'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);

insert into loai_khach
values (1,'Diamond');
insert into loai_khach
values (2,'Platinium');
insert into loai_khach
values (3,'Gold');
insert into loai_khach
values (4,'Silver');
insert into loai_khach
values (5,'Member');

insert into khach_hang
values (1,'Nguyễn Thị Hào','1970-11-07',0,'643431213',
'0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5);
insert into khach_hang
values (2,'Phạm Xuân Diệu','1992-08-08',1,'865342123',
'0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3);
insert into khach_hang
values (3,'Trương Đình Nghệ','1990-02-27',1,'488645199',
'0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1);
insert into khach_hang
values (4,'Dương Văn Quan','1981-07-08',1,'543432111',
'0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1);
insert into khach_hang
values (5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345',
'0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4);
insert into khach_hang
values (6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215',
'0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4);
insert into khach_hang
values (7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123',
'0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1);
insert into khach_hang
values (8,'Đỗ Thị Định','1999-04-08',0,'965656433',
'0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3);
insert into khach_hang
values (9,'Trần Đại Danh','1994-07-01',1,'432341235',
'0643343433','danhhai99@gmail.com,','24 Lý Thường Kiệt, Quảng Ngãi',1);
insert into khach_hang
values (10,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432',
'0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

insert into kieu_thue
values (1,'year');
insert into kieu_thue
values (2,'month');
insert into kieu_thue
values (3,'day');
insert into kieu_thue
values (4,'hour');

insert into loai_dich_vu
values (1,'Villa');
insert into loai_dich_vu
values (2,'House');
insert into loai_dich_vu
values (3,'Room');

insert into dich_vu
values (1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1);
insert into dich_vu
values (2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2);
insert into dich_vu
values (3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3);
insert into dich_vu
values (4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1);
insert into dich_vu
values (5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2);
insert into dich_vu
values (6,'Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);

insert into dich_vu_di_kem
values (1,'Karaoke',10000,'giờ','tiện nghi, hiện đại');
insert into dich_vu_di_kem
values (2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe');
insert into dich_vu_di_kem
values (3,'Thuê xe đạp',20000,'chiếc','tốt');
insert into dich_vu_di_kem
values (4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng');
insert into dich_vu_di_kem
values (5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng');
insert into dich_vu_di_kem
values (6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

insert into hop_dong
values (1,'2020-12-08','2020-12-08',0,3,1,3);
insert into hop_dong
values (2,'2020-07-14','2020-07-21',200000,7,3,1);
insert into hop_dong
values (3,'2021-03-15','2021-03-17',50000,3,4,2);
insert into hop_dong
values (4,'2021-01-14','2021-01-18',100000,7,5,5);
insert into hop_dong
values (5,'2021-07-14','2021-07-15',0,7,2,6);
insert into hop_dong
values (6,'2021-06-01','2021-06-03',0,7,7,6);
insert into hop_dong
values (7,'2021-09-02','2021-09-05',100000,7,4,4);
insert into hop_dong
values (8,'2021-06-17','2021-06-18',150000,3,4,1);
insert into hop_dong
values (9,'2020-11-19','2020-11-19',0,3,4,3);
insert into hop_dong
values (10,'2021-04-12','2021-04-14',0,10,3,5);
insert into hop_dong
values (11,'2021-04-25','2021-04-25',0,2,2,1);
insert into hop_dong
values (12,'2021-05-25','2021-05-27',0,7,10,1);

insert into hop_dong_chi_tiet
values (1,5,2,4);
insert into hop_dong_chi_tiet
values (2,8,2,5);
insert into hop_dong_chi_tiet
values (3,15,2,6);
insert into hop_dong_chi_tiet
values (4,1,3,1);
insert into hop_dong_chi_tiet
values (5,11,3,2);
insert into hop_dong_chi_tiet
values (6,1,1,3);
insert into hop_dong_chi_tiet
values (7,2,1,2);
insert into hop_dong_chi_tiet
values (8,2,12,2);

-- TASK 2
select *
from nhan_vien
where ho_ten regexp '^[h|k|t].{0,14}$';

-- TASK 3
select k_h.ma_khach_hang, k_h.ho_ten, (YEAR(CURDATE()) - YEAR(k_h.ngay_sinh)) as so_tuoi, k_h.dia_chi  
from khach_hang k_h
where ((YEAR(CURDATE()) - YEAR(k_h.ngay_sinh)) between 18 and 50) 
and k_h.dia_chi like '%Đà Nẵng' or k_h.dia_chi like '%Quảng Trị';

-- TASK 4
select k_h.ma_khach_hang, k_h.ho_ten, k_h.ma_loai_khach, count(h_d.ma_khach_hang) as so_lan_book_dich_vu
from khach_hang k_h inner join hop_dong h_d on k_h.ma_khach_hang = h_d.ma_khach_hang
where k_h.ma_loai_khach = 1
group by k_h.ma_khach_hang
order by count(h_d.ma_khach_hang);

-- TASK 5
select k_h.ma_khach_hang, k_h.ho_ten, l_k.ten_loai_khach, h_d.ma_hop_dong, 
d_v.ten_dich_vu, h_d.ngay_lam_hop_dong, h_d.ngay_ket_thuc,
sum(d_v.chi_phi_thue + ifnull((h_d_c_t.so_luong * d_v_d_k.gia),0)) as tong_tien
from khach_hang k_h inner join loai_khach l_k on k_h.ma_loai_khach = l_k.ma_loai_khach
left join hop_dong h_d on k_h.ma_khach_hang = h_d.ma_khach_hang
left join dich_vu d_v on h_d.ma_dich_vu = d_v.ma_dich_vu
left join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
left join dich_vu_di_kem d_v_d_k on h_d_c_t.ma_dich_vu_di_kem = d_v_d_k.ma_dich_vu_di_kem
group by h_d.ma_hop_dong
order by k_h.ma_khach_hang;

-- TASK 6
select d_v.ma_dich_vu, d_v.ten_dich_vu, d_v.dien_tich, d_v.chi_phi_thue, l_d_v.ten_loai_dich_vu
from dich_vu d_v inner join loai_dich_vu l_d_v on d_v.ma_loai_dich_vu = l_d_v.ma_loai_dich_vu
inner join hop_dong h_d on d_v.ma_dich_vu = h_d.ma_dich_vu
where d_v.ten_dich_vu not in  
(select d_v.ten_dich_vu from dich_vu d_v inner join hop_dong h_d on d_v.ma_dich_vu = h_d.ma_dich_vu
where h_d.ngay_lam_hop_dong between '2021-01-01 00:00:00' and '2021-03-31 23:59:59')
group by d_v.ma_dich_vu;

-- TASK 7
select d_v.ma_dich_vu, d_v.ten_dich_vu, d_v.dien_tich, d_v.so_nguoi_toi_da,
d_v.chi_phi_thue, l_d_v.ten_loai_dich_vu
from dich_vu d_v inner join loai_dich_vu l_d_v on d_v.ma_loai_dich_vu = l_d_v.ma_loai_dich_vu
inner join hop_dong h_d on d_v.ma_dich_vu = h_d.ma_dich_vu
where h_d.ngay_lam_hop_dong between '2020-01-01 00:00:00' and '2020-12-31 23:59:59'
group by d_v.ten_dich_vu
having d_v.ten_dich_vu not in
(select d_v.ten_dich_vu 
from dich_vu d_v inner join hop_dong h_d on d_v.ma_dich_vu = h_d.ma_dich_vu
where h_d.ngay_lam_hop_dong between '2021-01-01 00:00:00' and '2021-12-31 23:59:59');

-- TASK 8
select distinct khach_hang.ho_ten
from khach_hang;

select k_h.ho_ten
from khach_hang k_h
group by k_h.ho_ten;

select khach_hang.ho_ten 
from khach_hang 
union 
select khach_hang.ho_ten 
from khach_hang;

-- TASK 9
select month(h_d.ngay_lam_hop_dong) thang_trong_nam_2021, 
count(month(h_d.ngay_lam_hop_dong)) so_khach_dat_phong
from hop_dong h_d
where year(ngay_lam_hop_dong) = '2021'
group by thang_trong_nam_2021
order by thang_trong_nam_2021;

-- TASK 10
select h_d.ma_hop_dong, h_d.ngay_lam_hop_dong, h_d.ngay_ket_thuc, h_d.tien_dat_coc, 
sum(ifnull(so_luong,0)) as so_luong_dich_vu_di_kem
from hop_dong h_d left join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
group by h_d.ma_hop_dong;

-- TASK 11
select d_v_d_k.ma_dich_vu_di_kem , d_v_d_k.ten_dich_vu_di_kem
from khach_hang k_h inner join hop_dong h_d on k_h.ma_khach_hang = h_d.ma_khach_hang
inner join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
inner join dich_vu_di_kem d_v_d_k on h_d_c_t.ma_dich_vu_di_kem = d_v_d_k.ma_dich_vu_di_kem
inner join loai_khach l_k on k_h.ma_loai_khach = l_k.ma_loai_khach
where (l_k.ten_loai_khach = 'Diamond') and (k_h.dia_chi like '%Vinh' or '%Quảng Ngãi');

-- TASK 12
select h_d.ma_hop_dong, n_v.ho_ten, k_h.ho_ten, k_h.so_dien_thoai, d_v.ma_dich_vu,
d_v.ten_dich_vu, sum(ifnull(so_luong,0)) as so_luong_dich_vu_di_kem
from hop_dong h_d left join nhan_vien n_v on h_d.ma_nhan_vien = n_v.ma_nhan_vien
left join khach_hang k_h on h_d.ma_khach_hang = k_h.ma_khach_hang
left join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
left join dich_vu d_v on h_d.ma_dich_vu = d_v.ma_dich_vu
where d_v.ten_dich_vu in
(select d_v.ten_dich_vu from hop_dong h_d inner join dich_vu d_v on h_d.ma_dich_vu = d_v.ma_dich_vu
where h_d.ngay_lam_hop_dong between '2020-10-01 00:00:00' and '2020-12-31 23:59:59')
group by h_d.ma_hop_dong
having d_v.ten_dich_vu not in
(select d_v.ten_dich_vu from hop_dong h_d inner join dich_vu d_v on h_d.ma_dich_vu = d_v.ma_dich_vu
where h_d.ngay_lam_hop_dong between '2021-01-01 00:00:00' and '2021-06-30 23:59:59');

-- TASK 13 (chưa chắc chắn)
select d_v_d_k.ma_dich_vu_di_kem, d_v_d_k.ten_dich_vu_di_kem, 
sum(so_luong) as so_luong_dich_vu_di_kem
from hop_dong_chi_tiet h_d_c_t inner join dich_vu_di_kem d_v_d_k 
on h_d_c_t.ma_dich_vu_di_kem = d_v_d_k.ma_dich_vu_di_kem
group by d_v_d_k.ma_dich_vu_di_kem
having sum(so_luong) in
(select max(so_luong)
from hop_dong_chi_tiet);

-- TASK 14
select h_d.ma_hop_dong, l_d_v.ten_loai_dich_vu, d_v_d_k.ten_dich_vu_di_kem,
count(h_d_c_t.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong h_d inner join dich_vu d_v on h_d.ma_dich_vu = d_v.ma_dich_vu
inner join loai_dich_vu l_d_v on d_v.ma_loai_dich_vu = l_d_v.ma_loai_dich_vu
inner join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
inner join dich_vu_di_kem d_v_d_k on h_d_c_t.ma_dich_vu_di_kem = d_v_d_k.ma_dich_vu_di_kem
group by d_v_d_k.ten_dich_vu_di_kem
having count(h_d_c_t.ma_dich_vu_di_kem) = 1
order by h_d.ma_hop_dong;

-- TASK 15
select n_v.ma_nhan_vien, n_v.ho_ten, t_d.ten_trinh_do, b_p.ten_bo_phan, n_v.so_dien_thoai, n_v.dia_chi
from nhan_vien n_v inner join hop_dong h_d on h_d.ma_nhan_vien = n_v.ma_nhan_vien
inner join trinh_do t_d on n_v.ma_trinh_do = t_d.ma_trinh_do
inner join bo_phan b_p on n_v.ma_bo_phan = b_p.ma_bo_phan
where year(h_d.ngay_lam_hop_dong) between '2020' and '2021'
group by n_v.ma_nhan_vien
having count(h_d.ma_hop_dong) < 4
order by n_v.ma_nhan_vien;

-- TASK 16
set sql_safe_updates = 0;
delete 
from nhan_vien n_v
where n_v.ma_nhan_vien not in
(select distinct ma_nhan_vien
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between '2019' and '2021');
set sql_safe_updates = 1;

-- TASK 17
update khach_hang
set ma_loai_khach = 1
where ma_loai_khach !=1 
and ma_khach_hang in 
(select tong_tien.ma_khach_hang 
from (select khach_hang.ma_khach_hang
from khach_hang 
inner join hop_dong  on hop_dong.ma_khach_hang=khach_hang.ma_khach_hang
inner join dich_vu  on dich_vu.ma_dich_vu=hop_dong.ma_dich_vu
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by khach_hang.ma_khach_hang
having (SUM(ifnull(dich_vu.chi_phi_thue,0) + 
ifnull(dich_vu_di_kem.gia,0)* ifnull(hop_dong_chi_tiet.so_luong,0))>=10000000)) as tong_tien);

select khach_hang.ma_khach_hang ,
khach_hang.ho_ten,
khach_hang.ma_loai_khach = 1 as loai_dich_vu
from khach_hang;

select *
from khach_hang;

-- TASK 18

set sql_safe_updates = 0;
set foreign_key_checks = 0;
delete 
from khach_hang k_h
where k_h.ma_khach_hang in
(select distinct ma_khach_hang
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) between '0' and '2020');
set foreign_key_checks = 1;
set sql_safe_updates = 1;

select *
from khach_hang;

-- TASK 19
create temporary table update_gia
select d_v_d_k.ma_dich_vu_di_kem, d_v_d_k.ten_dich_vu_di_kem
from dich_vu_di_kem d_v_d_k inner join hop_dong_chi_tiet h_d_c_t on d_v_d_k.ma_dich_vu_di_kem = h_d_c_t.ma_dich_vu_di_kem
inner join hop_dong h_d on h_d_c_t.ma_hop_dong = h_d.ma_hop_dong
where h_d_c_t.so_luong > 10 and
year(h_d.ngay_lam_hop_dong) = 2020;

select * from update_gia;

update dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
where dich_vu_di_kem.ma_dich_vu_di_kem in 
(select update_gia.ma_dich_vu_di_kem from update_gia);

drop temporary table update_gia;

-- TASK 20
select n_v.ma_nhan_vien as id, n_v.ho_ten, n_v.email,
 n_v.so_dien_thoai, n_v.ngay_sinh, n_v.dia_chi
from nhan_vien n_v
union all
select k_h.ma_khach_hang as id, k_h.ho_ten, k_h.email,
 k_h.so_dien_thoai, k_h.ngay_sinh, k_h.dia_chi
 from khach_hang k_h;

-- TASK 21
create or replace view v_nhan_vien as
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,nhan_vien.dia_chi from nhan_vien
inner join hop_dong on nhan_vien.ma_nhan_vien= hop_dong.ma_nhan_vien
where (nhan_vien.dia_chi like  '%Yên Bái%') and hop_dong.ngay_lam_hop_dong= '2021-04-25'
group by hop_dong.ma_nhan_vien;

select * from v_nhan_vien;

drop view v_nhan_vien;


-- TASK 22
set sql_safe_updates=0;
update nhan_vien
set dia_chi ='Liên Chiểu'
where  nhan_vien.dia_chi
 in  (select dia_chi from v_nhan_vien as x);
set sql_safe_updates=1;