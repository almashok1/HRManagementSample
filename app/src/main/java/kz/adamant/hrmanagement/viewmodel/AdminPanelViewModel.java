package kz.adamant.hrmanagement.viewmodel;

import android.app.Application;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kz.adamant.hrmanagement.models.Department;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.Position;
import kz.adamant.hrmanagement.models.tableview.Cell;
import kz.adamant.hrmanagement.models.tableview.ColumnHeader;
import kz.adamant.hrmanagement.models.tableview.RowHeader;
import kz.adamant.hrmanagement.repository.HRRepository;

public class AdminPanelViewModel extends AndroidViewModel {
    private HRRepository hrRepository;

    private MutableLiveData<Integer> depIdSelected = new MutableLiveData<>();
    private MutableLiveData<Integer> posIdSelected = new MutableLiveData<>();

    private LiveData<List<Department>> departments;
    private LiveData<List<Position>> positions;

    private LiveData<List<HRData>> employeesByPosition;


    public AdminPanelViewModel(@NonNull Application application) {
        super(application);
        hrRepository = HRRepository.getInstance(application);
        departments = hrRepository.getDepartments();
        positions = Transformations.switchMap(depIdSelected, depID ->
                hrRepository.getPositions(depID));
        employeesByPosition = Transformations.switchMap(posIdSelected, posID ->
                hrRepository.getEmployeesByPosition(posID));
    }

    public MutableLiveData<Integer> getDepIdSelected() {
        return depIdSelected;
    }

    public LiveData<List<Department>> getDepartments() {
        return departments;
    }

    public LiveData<List<Position>> getPositions() {
        return positions;
    }

    public MutableLiveData<Integer> getPosIdSelected() {
        return posIdSelected;
    }

    public LiveData<List<HRData>> getEmployeesByPosition() {
        return employeesByPosition;
    }


}
