-Sub-query

select * from tblEmployee
where empSalary>=(select avg(empSalary) from tblEmployee)


select tblEmployee.empSSN, empName,empAddress,c.depSex
from tblEmployee,(select empSSN,depSex from tblDependent) c
where tblEmployee.empSSN=c.empSSN


--AVG,MAX,MIN,MAX,SUM
select * from tblEmployee
where empSalary>=(select avg(empSalary) from tblEmployee)


select * from tblEmployee where empSalary=
(select max(empSalary) from tblEmployee)


select * from tblEmployee where empSalary=
(select min(empSalary) from tblEmployee)


select count(empSSN) as 'Tổng số nhân viên' from tblEmployee


select * from tblWorksOn order by empSSN asc


--Tính tiền trên số giờ
select e.empName,e.empSSN,d.[Tổng tiền]
from tblEmployee e,
(select empSSN,sum(workHours*price) as 'Tổng tiền' from tblWorksOn
group by empSSN) d
where e.empSSN=d.empSSN
