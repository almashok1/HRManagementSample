package kz.adamant.hrmanagement.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.TitleAndDescription;
import kz.adamant.hrmanagement.repository.HRRepository;

public class OverviewActivityViewModel extends AndroidViewModel {
    private HRRepository hrRepository;
    private LiveData<HRData> employee;
    private LiveData<List<TitleAndDescription>> colleagues;

    public OverviewActivityViewModel(@NonNull Application application, int employeeID) {
        super(application);
        hrRepository = HRRepository.getInstance(application);
        employee = hrRepository.getEmployeeByID(employeeID);
        colleagues = Transformations.switchMap(employee, e -> {
            Log.d("colleges", "OverviewActivityViewModel: " + e.getPositionID() + " - " + e.getPosition());
            return hrRepository.getColleagues(e.getPositionID(), e.getEmpID());
        });
    }

    public LiveData<HRData> getEmployee() {
        return employee;
    }

    public LiveData<List<TitleAndDescription>> getColleagues() {
        return colleagues;
    }
}
