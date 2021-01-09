package kz.adamant.hrmanagement.repository;

import android.app.Application;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kz.adamant.hrmanagement.db.HRDao;
import kz.adamant.hrmanagement.db.HRDatabase;
import kz.adamant.hrmanagement.models.Department;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.Position;
import kz.adamant.hrmanagement.models.TitleAndDescription;

public class HRRepository {
    private HRDao hrDao;
    private static HRRepository instance;

    public static synchronized HRRepository getInstance(Application application) {
        if (instance == null) {
            instance = new HRRepository(application);
        }
        return instance;
    }

    private HRRepository(Application application) {
        HRDatabase hrDatabase = HRDatabase.getInstance(application);
        hrDao = hrDatabase.hrDao();
    }

    public LiveData<Integer> getCountOfEmployee(int employeeID) {
           return hrDao.getCountOfEmployee(employeeID);
    }

    public LiveData<HRData> getEmployeeByID(int employeeID) {
        return hrDao.getEmployeeByID(employeeID);
    }

    public LiveData<List<TitleAndDescription>> getColleagues(int positionID, int empID) {
       return hrDao.getColleagues(positionID, empID);
    }

    public LiveData<List<Department>> getDepartments() {
        return hrDao.getDepartments();
    }

    public LiveData<List<Position>> getPositions(Integer depID) {
        return hrDao.getPositions(depID);
    }

    public LiveData<List<HRData>> getEmployeesByPosition(int posID) {
        return hrDao.getEmployeesByPosition(posID);
    }

    public LiveData<List<HRData>> getPositionsByEmpIds(int[] emps) {
        return hrDao.getPositionsByEmpIds(emps);
    }

    public LiveData<List<Position>> getPositionsByArray(int[] pos) {
        return hrDao.getPositionsByArray(pos);
    }
}
