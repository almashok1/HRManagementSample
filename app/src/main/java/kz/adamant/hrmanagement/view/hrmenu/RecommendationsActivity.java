package kz.adamant.hrmanagement.view.hrmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.tbuonomo.creativeviewpager.CreativeViewPager;
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.EmpRec;
import kz.adamant.hrmanagement.models.Role;
import kz.adamant.hrmanagement.view.adapters.RecommendationViewPagerAdapter;
import kz.adamant.hrmanagement.viewmodel.AdminPanelViewModel;
import kz.adamant.hrmanagement.viewmodel.RecommendationViewModel;

public class RecommendationsActivity extends AppCompatActivity {
    RecommendationViewModel recommendationViewModel;
    CreativeViewPager viewPager;
    RecommendationViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        viewPager = findViewById(R.id.creativeViewPagerView);
        int posId = getIntent().getIntExtra("posId", -1);
        int empId = getIntent().getIntExtra("empId", -1);
        recommendationViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(RecommendationViewModel.class);
        if (posId != -1) {
            recommendationViewModel.posId.setValue(posId);
            recommendationViewModel.getAllRecommendationsForPos().observe(this, observer -> {
                String[] recsStr = observer.getRecommendations().split(",");
                int[] parsed = new int[recsStr.length];
                for (int i = 0; i < recsStr.length; i++) {
                    parsed[i] = Integer.parseInt(recsStr[i]);
                }
                recommendationViewModel.getSearchEmps().setValue(parsed);
            });

            recommendationViewModel.getRecommendedEmps().observe(this, emps -> {
                adapter = new RecommendationViewPagerAdapter(this, emps, null);
                viewPager.setCreativeViewPagerAdapter(adapter);
            });
        } else if (empId != -1) {
            recommendationViewModel.empId.setValue(empId);
            recommendationViewModel.getAllRecommendationsForEmp().observe(this, observer -> {
                String[] recsStr = observer.getRecommendations().split(",");
                int[] parsed = new int[recsStr.length];
                for (int i = 0; i < recsStr.length; i++) {
                    parsed[i] = Integer.parseInt(recsStr[i]);
                }
                Log.d("TAG", "onCreate: " + recsStr.length);
                recommendationViewModel.getSearchPos().setValue(parsed);
            });

            recommendationViewModel.getRecommendedPos().observe(this, positions -> {
                adapter = new RecommendationViewPagerAdapter(this, null, positions);
                viewPager.setCreativeViewPagerAdapter(adapter);
            });
        }

    }
}