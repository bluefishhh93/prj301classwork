CREATE DATABASE WorkShop1

USE WorkShop1

CREATE TABLE StudentTBL
(
	Id int identity(1,1) primary key,
	Name varchar(50),
	Gender bit,
	DOB date
)

INSERT INTO StudentTBL VALUES('Mr A','1','2016-12-02')
INSERT INTO StudentTBL VALUES('Mr B','1','2016-12-09')
INSERT INTO StudentTBL VALUES('Ms C','0','2016-12-07')

select * from StudentTBL