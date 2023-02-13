DML
--Câu này là để nhập thông tin........
select EmployeeID as 'Mã nhân viên' from Employee


select * from Employee
insert into Employee values(1,'tongquan')
insert into Employee values(2,'tong')
insert into Employee values(3,'quan')


update Employee set Name='tong phuoc quan'
where EmployeeID=1


delete from Employee
where EmployeeID=1


truncate table Employee


select empName as 'Tên nhân viên',year(getdate())-year(empBirthdate) as 'Tuổi'
from tblEmployee
where year(getdate())-year(empBirthdate)>60


SELECT  * FROM tblEmployee WHERE empName LIKE 'H%'
UNION
SELECT  * FROM tblEmployee WHERE empSalary > 80000


SELECT  empSSN FROM tblEmployee
EXCEPT
SELECT  supervisorSSN FROM tblEmployee