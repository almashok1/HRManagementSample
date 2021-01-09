package kz.adamant.hrmanagement.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import kz.adamant.hrmanagement.models.EmpRec;
import kz.adamant.hrmanagement.models.PosRec;

@Dao
public interface RecDao {
    @Query("SELECT EmpID, recommendations FROM rec_pos WHERE EmpID = :empId LIMIT 1")
    LiveData<PosRec> getAllRecommendationsForEmp(int empId);

    @Query("SELECT PositionID, recommendations FROM rec_emp WHERE PositionID = :posId LIMIT 1")
    LiveData<EmpRec> getAllRecommendationsForPos(int posId);
}
