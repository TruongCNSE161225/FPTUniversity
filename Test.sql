use Test
---one to many ralationship
create table author(authorID int not null,
authorName nvarchar(35) not null)
create table book(bookID int identity(1,1) primary key,
bookName nvarchar(50) not null,authorID int,
foreign key(authorID) references author(authorID))
select year(getdate())
alter table author
add quatity int
alter table author
drop column address
drop table author
ALTER TABLE author
ADD CONSTRAINT PK_author PRIMARY KEY(authorID)
insert into author values(1,'quan',1)
select * from author
delete from author
ALTER TABLE author
ADD CONSTRAINT ck_quatity CHECK (quatity>0)
---one to one relationship
CREATE TABLE Employee (
EmployeeID INT PRIMARY KEY
,   Name VARCHAR(50)
);
CREATE TABLE Salary (
EmployeeID INT UNIQUE NOT NULL
,   SalaryAmount  INT
);
ALTER TABLE Salary
ADD CONSTRAINT FK_Salary_Employee FOREIGN KEY(EmployeeID)
REFERENCES Employee(EmployeeID);
