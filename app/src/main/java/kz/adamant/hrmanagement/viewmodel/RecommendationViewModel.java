package kz.adamant.hrmanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import kz.adamant.hrmanagement.models.EmpRec;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.PosRec;
import kz.adamant.hrmanagement.models.Position;
import kz.adamant.hrmanagement.repository.HRRepository;
import kz.adamant.hrmanagement.repository.RecRepository;

public class RecommendationViewModel extends AndroidViewModel {
    private RecRepository recRepository;
    private HRRepository hrRepository;

    private LiveData<EmpRec> allRecommendationsForPos;
    private LiveData<PosRec> allRecommendationsForEmp;
    private LiveData<List<HRData>> recommendedEmps;
    private LiveData<List<Position>> recommendedPos;
    private MutableLiveData<int[]> searchEmps = new MutableLiveData<>();
    private MutableLiveData<int[]> searchPos = new MutableLiveData<>();
    public MutableLiveData<Integer> posId = new MutableLiveData<>();
    public MutableLiveData<Integer> empId = new MutableLiveData<>();

    public RecommendationViewModel(@NonNull Application application) {
        super(application);
        hrRepository = HRRepository.getInstance(application);
        recRepository = RecRepository.getInstance(application);
        allRecommendationsForPos = Transformations.switchMap(posId, pos -> {
            return recRepository.getAllRecommendationsForPos(pos);
        });
        allRecommendationsForEmp = Transformations.switchMap(empId, emp -> {
            return recRepository.getAllRecommendationsForEmp(emp);
        });
        recommendedEmps = Transformations.switchMap(searchEmps, emps->{
            return hrRepository.getPositionsByEmpIds(emps);
        });
        recommendedPos = Transformations.switchMap(searchPos, pos->{
            return hrRepository.getPositionsByArray(pos);
        });
    }

    public LiveData<EmpRec> getAllRecommendationsForPos() {
        return allRecommendationsForPos;
    }

    public LiveData<PosRec> getAllRecommendationsForEmp() {
        return allRecommendationsForEmp;
    }

    public MutableLiveData<int[]> getSearchEmps() {
        return searchEmps;
    }

    public LiveData<List<HRData>> getRecommendedEmps() {
        return recommendedEmps;
    }

    public MutableLiveData<int[]> getSearchPos() {
        return searchPos;
    }

    public LiveData<List<Position>> getRecommendedPos() {
        return recommendedPos;
    }
}
