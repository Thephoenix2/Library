use master
drop database QuanLyBaiGiuXe

create database QuanLyBaiGiuXe

use QuanLyBaiGiuXe
create table QuanLiVe(
MaVeXe nvarchar(20) primary key,
KhachHang nvarchar(50),
Hinh1 nvarchar(50),
Hinh2 nvarchar(50)
)

create table QuanLiXe(
id nvarchar(20) PRIMARY KEY,
MaVeXe nvarchar(20),
LoaiXe nvarchar(10),
KhachHang nvarchar(50),
NgayVao date,
Hinh1 nvarchar(50),
Hinh2 nvarchar(50),
Hinh3 nvarchar(50),
Hinh4 nvarchar(50),
NgayRa date
)



create table ThongKe(
	SoLuongXe int primary key,
    SoXeThang int not null,
  	SoTienNgay int not null,
	BienBan nvarchar(100) not null
)
create table DangNhap(
MaNV nvarchar(50) primary key,
TenDangNhap nvarchar(50) ,
MatKhau nvarchar(50)
)

alter table  QuanLiXe
add constraint Fk_HD4 foreign key (MaVeXe) references QuanLiVe(MaVeXe)

create proc spQuanLiVe_delete
@MaVeXe nvarchar(20)
as
delete from QuanLiVe
where MaVeXe=@MaVeXe
go

create proc spQuanLiXe_delete
@id nvarchar(20)
as
delete from QuanLiXe
where id=@id
go