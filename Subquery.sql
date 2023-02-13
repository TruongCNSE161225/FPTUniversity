--Sub-queries
SELECT  *
FROM  tblEmployee e, tblDepartment d
WHERE e.depNum=d.depNum AND d.depName LIKE N'Phòng phần mềm trong nước';
--


SELECT  *
FROM  tblEmployee
WHERE  depNum = (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  depNum = ANY (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  depNum IN (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  depNum = (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT *
FROM  tblProject
WHERE  locNum = (SELECT locNum
FROM tblProject
WHERE proName='ProjectA');


use FUH_COMPANY


SELECT *
FROM tblDependent d JOIN tblEmployee e ON d.empSSN<>e.empSSN


SELECT *
FROM tblDepartment d JOIN tblEmployee e ON d.depNum=e.depNum


SELECT *
FROM tblDependent CROSS JOIN tblEmployee


SELECT l.locNum, l.locName, p.proNum, p.proName
FROM tblLocation l right OUTER JOIN tblProject p ON l.locNum=p.locNum


SELECT  * FROM tblEmployee WHERE empName LIKE 'H%'
UNION
SELECT  * FROM tblEmployee WHERE empSalary > 80000
use FUH_COMPANY
select * from tblproject
select * from tblWorksOn order by proNum


SELECT  empSSN
FROM  tblWorksOn w, tblProject p
WHERE  w.proNum=p.proNum AND p.proName='ProjectB'
INTERSECT
SELECT  empSSN
FROM  tblWorksOn w, tblProject p
WHERE  w.proNum=p.proNum AND p.proName='ProjectC'
--*11*/


SELECT  *
FROM  tblEmployee e, tblDepartment d
WHERE e.depNum=d.depNum AND d.depName LIKE N'Phòng phần mềm trong nước';
--


SELECT  *
FROM  tblEmployee
WHERE  depNum = (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  depNum = ANY (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  depNum IN (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng phần mềm trong nước');


SELECT  *
FROM  tblEmployee
WHERE  empSalary>=ALL (SELECT  empSalary
FROM  tblEmployee);


SELECT  *
FROM  tblEmployee
WHERE  empSalary<=ALL (SELECT  empSalary
FROM  tblEmployee);


SELECT  *
FROM  tblEmployee
WHERE  Exists (SELECT depNum
FROM tblDepartment
WHERE depName=N'Phòng');


select * from tblDepartment


SELECT  *
FROM  tblEmployee e join tblDepartment d on e.depNum=d.depNum
AND d.depName LIKE N'Phòng phần mềm trong nước';


SELECT  *
FROM  tblEmployee e right join tblDepartment d on e.depNum=d.depNum
AND d.depName LIKE N'Phòng phần mềm trong nước';
---join 3 bảng


SELECT  e.empSSN,e.empName,e.empSex,de.depName
FROM tblEmployee e join tblDepartment d on e.depNum=d.depNum
join tblDependent de on e.empSSN=de.empSSN
AND d.depName LIKE N'Phòng phần mềm trong nước';