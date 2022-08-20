create database quan_ly_vat_tu;
use quan_ly_vat_tu;

create table vat_tu(
ma_vt varchar(20) primary key,
ten_vt varchar(50)
);

create table phieu_nhap(
so_pn int primary key auto_increment,
ngay_nhap datetime
);

create table chi_tiet_phieu_nhap(
ma_vt varchar(20),
so_pn int,
dg_nhap int,
sl_nhap int,
-- primary key (ma_vt,so_pn),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_pn) references phieu_nhap(so_pn)
);

alter table chi_tiet_phieu_nhap ADD primary key(ma_vt,so_pn);

create table phieu_xuat(
so_px int primary key auto_increment,
ngay_xuat datetime
);

create table chi_tiet_phieu_xuat(
ma_vt varchar(20),
so_px int,
dg_xuat int,
sl_xuat int,
-- primary key (ma_vt, so_px),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_px) references phieu_xuat(so_px)
);

alter table chi_tiet_phieu_xuat ADD primary key(ma_vt,so_pn);

create table nha_cung_cap(
ma_ncc varchar(20) primary key,
ten_ncc varchar(20),
dia_chi varchar(50),
sdt varchar(10),
unique (sdt)
);

create table sdt_ncc(
sdt varchar(10) primary key,
foreign key (sdt) references nha_cung_cap(sdt)
);


create table don_dat_hang(
so_dh int primary key auto_increment,
ngay_dh datetime,
ma_ncc varchar(20),
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);

create table chi_tiet_don_dat_hang(
ma_vt varchar(20),
so_dh int,
-- primary key (ma_vt, so_dh),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_dh) references don_dat_hang(so_dh)
);

alter table chi_tiet_don_dat_hang ADD primary key(ma_vt, so_dh);
