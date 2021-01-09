package kz.adamant.hrmanagement.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import kz.adamant.hrmanagement.models.Department;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.Position;
import kz.adamant.hrmanagement.models.TitleAndDescription;

@Dao
public interface HRDao {
    @Query("SELECT count(EmpID) FROM hr_table WHERE EmpID = :employeeID")
    LiveData<Integer> getCountOfEmployee(int employeeID);

    @Query("SELECT * FROM hr_table WHERE EmpID = :employeeID LIMIT 1")
    LiveData<HRData> getEmployeeByID(int employeeID);

    @Query("SELECT Employee_Name, Position FROM hr_table WHERE PositionID = :positionID AND EmpID != :empID ORDER BY EngagementSurvey")
    LiveData<List<TitleAndDescription>> getColleagues(int positionID, int empID);

    @Query("SELECT DeptID, Department FROM hr_table GROUP BY DeptID")
    LiveData<List<Department>> getDepartments();

    @Query("SELECT PositionID, Position, AVG(Salary) as AverageSalary FROM hr_table WHERE DeptID = :depID GROUP BY PositionID")
    LiveData<List<Position>> getPositions(Integer depID);

    @Query("SELECT * FROM hr_table WHERE PositionID = :posID")
    LiveData<List<HRData>> getEmployeesByPosition(int posID);

    @Query("SELECT * FROM hr_table WHERE EmpID IN(:empIds)")
    LiveData<List<HRData>> getPositionsByEmpIds(int[] empIds);

    @Query("SELECT PositionID, Position, AVG(Salary) as AverageSalary FROM hr_table WHERE PositionID IN(:pos) GROUP BY PositionID")
    LiveData<List<Position>> getPositionsByArray(int[] pos);
}
