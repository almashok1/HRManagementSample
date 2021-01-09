package kz.adamant.hrmanagement.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface AdminDao {
    @Query("SELECT count(*) FROM admin_table WHERE login = :adminLogin")
    LiveData<Integer> getCountOfEmployee(String adminLogin);
}
