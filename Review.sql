--Question 2
CREATE TABLE Department(
DepartmentID CHAR(5) PRIMARY KEY 
, Name VARCHAR(50) UNIQUE
);

CREATE TABLE Employee(
EmployeeID CHAR(5) PRIMARY KEY
, Name VARCHAR(50)
, DepartmentFK CHAR(5)
, BirthDate DATETIME DEFAULT ('6/10/1970')
, FOREIGN KEY (DepartmentFK) REFERENCES Department
);

--Question 3
INSERT INTO Employee VALUES(001, 'Chau Nhat Truong', 101, '9/25/2002')
INSERT INTO Employee VALUES(002, 'Nguyen Van A', 102, '1/25/2000')
INSERT INTO Employee VALUES(003, 'Tran Van C', 103, '5/25/2001')

INSERT INTO Department VALUES(101, 'Tuyen Sinh')
INSERT INTO Department VALUES(102, 'Dao Tao')
INSERT INTO Department VALUES(103, 'Giam Hieu')

--Question 4
CREATE VIEW ViewEmployees AS 
SELECT e.EmployeeID, e.Name, e.BirthDate, d.Name as 'DepartmentName' FROM Employee e, Department d
WHERE e.DepartmentFK = d.DepartmentID ORDER BY d.Name ASC

--Question 5




