package kz.adamant.hrmanagement.repository;

import android.app.Application;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kz.adamant.hrmanagement.db.AdminDao;
import kz.adamant.hrmanagement.db.HRDatabase;
import kz.adamant.hrmanagement.models.Admin;

public class AdminRepository {
    private AdminDao adminDao;
    private static AdminRepository instance;

    public static synchronized AdminRepository getInstance(Application application) {
        if (instance == null) {
            instance = new AdminRepository(application);
        }
        return instance;
    }

    private AdminRepository(Application application) {
        HRDatabase hrDatabase = HRDatabase.getInstance(application);
        adminDao = hrDatabase.adminDao();
    }

    public LiveData<Integer> getCountOfAdmin(String login) {
        return adminDao.getCountOfEmployee(login);
    }
}