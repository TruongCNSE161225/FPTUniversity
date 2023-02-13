--Transaction and view
BEGIN TRY
  BEGIN TRAN
   INSERT tblProject
   VALUES (13,'DBI',1,1)
   INSERT tblWorksOn
   VALUES ('30121050027',7,20)
  COMMIT TRAN
END TRY
BEGIN CATCH
  ROLLBACK TRAN
  print N'giao dịch lỗi'
END CATCH

SELECT * FROM tblWorksOn

--View
create view Employee_vv
as
select empSSN,empName from tblEmployee

SELECT * FROM Employee_vv


select w.empSSN,e.empName,w.proNum,w.workHours
from tblWorksOn w join Employee_vv e on w.empSSN=e.empSSN