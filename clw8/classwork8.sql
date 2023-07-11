CREATE DATABASE ClassWork8

USE ClassWork8

CREATE TABLE UserTBL
(	
    Id int identity(1,1) primary key,
	username varchar(50),
	password varchar(50)
)

INSERT INTO UserTBL VALUES('usernamea','123')
INSERT INTO UserTBL VALUES('usernameb','123')

SELECT * FROM UserTBL