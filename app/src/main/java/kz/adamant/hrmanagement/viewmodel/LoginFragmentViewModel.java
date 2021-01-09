package kz.adamant.hrmanagement.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import kz.adamant.hrmanagement.models.Admin;
import kz.adamant.hrmanagement.models.UsernamePassword;
import kz.adamant.hrmanagement.repository.AdminRepository;
import kz.adamant.hrmanagement.repository.HRRepository;

public class LoginFragmentViewModel extends AndroidViewModel {
    private HRRepository hrRepository;
    private AdminRepository adminRepository;
    private LiveData<Integer> countOfEmployee;
    private LiveData<Integer> countOfAdmin;
    private MutableLiveData<UsernamePassword> etEmployee = new MutableLiveData<>();
    private MutableLiveData<Admin> etAdmin = new MutableLiveData<>();

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        hrRepository = HRRepository.getInstance(application);
        adminRepository = AdminRepository.getInstance(application);

        countOfEmployee = Transformations.switchMap(etEmployee, emp ->
                hrRepository.getCountOfEmployee(emp.getEmployeeID()));
        countOfAdmin = Transformations.switchMap(etAdmin, admin ->
                adminRepository.getCountOfAdmin(admin.getLogin()));
    }

    public LiveData<Integer> getCountOfEmployee() {
        return countOfEmployee;
    }

    public MutableLiveData<UsernamePassword> getEtEmployee() {
        return etEmployee;
    }

    public MutableLiveData<Admin> getEtAdmin() {
        return etAdmin;
    }

    public LiveData<Integer> getCountOfAdmin() {
        return countOfAdmin;
    }
}
