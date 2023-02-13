---Function
select * from tblEmployee

create function fn_tblEmployee1(@depNum int)
Returns @tblEmployee table(empSSN decimal,empName nvarchar(50),depNum int)
as
	begin
	insert into @tblEmployee(empSSN,empName,depNum)
	select empSSN,empName,depNum from tblEmployee where depNum=@depNum
	return
	end
go


select * from fn_tblEmployee1(1)


---Trigger
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
drop trigger Tr_Employee_Insert
go

CREATE TRIGGER Tr_Employee_Insert ON tblEmployee
AFTER INSERT
AS
RAISERROR('Insert trigger is awakened',16,1)
go

insert into tblEmployee(empSSN) values('3012104444')

IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
drop trigger Tr_Employee_Insert
go

CREATE TRIGGER Tr_Employee_Insert ON tblEmployee
AFTER INSERT
AS
RAISERROR('Insert trigger is awakened',16,1)
ROLLBACK TRANSACTION
go


--test
INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum)
VALUES (3012109999, N'Nguyễnn Văn Tý', 10000, 1)

--not found employee whose empSSN is 30121050345
SELECT * FROM tblEmployee WHERE empSSN=30121050345
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
drop trigger Tr_Employee_Insert
go


CREATE TRIGGER Tr_Employee_Insert2 ON tblEmployee
AFTER INSERT
AS
DECLARE @vEmpSSN DECIMAL, @vEmpName NVARCHAR(50)
SELECT @vEmpSSN=empSSN FROM inserted
SELECT @vEmpName=empName FROM inserted
PRINT 'new tuple:'
PRINT 'empSSN=' + CAST(@vEmpSSN AS nvarchar(11)) + ' empName=' + @vEmpName
go


--test
INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121012345, N'Nguyễn Văn Tý', 10000, 1, 30121050037);


--Không có tham số
CREATE FUNCTION fCountEmp()
RETURNS INT
BEGIN
	RETURN (SELECT COUNT(empSSN) FROM tblEmployee)
END

--Có tham số
CREATE FUNCTION fCountEmp_Sex (@sex NVARCHAR(5))
RETURNS INT
BEGIN
	RETURN (SELECT COUNT(empSSN)
	FROM tblEmployee
	WHERE empSex LIKE @sex)
END

--Call function không có tham số cách 1
PRINT 'Amount: ' + CONVERT(VARCHAR, dbo.fCountEmp())

--Call function không có tham số cách 2
DECLARE @sum INT
SELECT @sum=dbo.fCountEmp()

--Call function có tham số
PRINT 'Amount: ' + CONVERT(VARCHAR, dbo.fCountEmp_Sex('M'))

--Trigger
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
drop trigger Tr_Employee_Insert
go

SELECT * FROM tblProject
CREATE TRIGGER Project_Deletion 
ON tblProject
FOR DELETE
AS
	BEGIN
		DECLARE @proNum INT;
		SELECT @proNum = COUNT(*) FROM deleted
		PRINT 'No. of project has been deleted' + CONVERT(VARCHAR(5), @proNum)
	END

delete from tblProject
where proNum = 7