CREATE DATABASE EmpManagement;
USE EmpManagement;
CREATE TABLE tblEmployee
(IdEmp INT identity(1,1) PRIMARY KEY,
EmpName nvarchar(50) NOT NULL,
DOB date CHECK(year(getdate())-year(DOB)>=18),
PhoneNo char(12) Unique,
Addr nvarchar(50) DEFAULT N'Hồ Chí Minh'
);
