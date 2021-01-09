package kz.adamant.hrmanagement.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

import kz.adamant.hrmanagement.db.AdminDao;
import kz.adamant.hrmanagement.db.HRDatabase;
import kz.adamant.hrmanagement.db.RecDao;
import kz.adamant.hrmanagement.models.EmpRec;
import kz.adamant.hrmanagement.models.PosRec;

public class RecRepository {
    private RecDao recDao;
    private static RecRepository instance;

    public static synchronized RecRepository getInstance(Application application) {
        if (instance == null) {
            instance = new RecRepository(application);
        }
        return instance;
    }

    private RecRepository(Application application) {
        HRDatabase hrDatabase = HRDatabase.getInstance(application);
        recDao = hrDatabase.recDao();
    }

    public LiveData<PosRec> getAllRecommendationsForEmp(int empId){
        return recDao.getAllRecommendationsForEmp(empId);
    }

    public LiveData<EmpRec> getAllRecommendationsForPos(int posId){
        return recDao.getAllRecommendationsForPos(posId);
    }
}
