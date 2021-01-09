package kz.adamant.hrmanagement.view.hrmenu.employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.MaterialColorPalette;
import kz.adamant.hrmanagement.models.TitleAndDescription;
import kz.adamant.hrmanagement.view.hrmenu.RecommendationsActivity;
import kz.adamant.hrmanagement.viewmodel.OverviewActivityViewModel;

public class OverviewActivity extends AppCompatActivity {
    private OverviewActivityViewModel overviewActivityViewModel;

    private TextView tvFirstName,
            tvAbsences,
            tvDaysLateLast30,
            tvPosition,
            tvSpecialProjects,
            tvLastReviewDate,
            tvSatisfaction;

    private View satisfactionBar;
    private LinearLayout colleaguesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        int empId = getIntent().getIntExtra("id", -1);
        overviewActivityViewModel = new ViewModelProvider(this,
                new IdViewModelFactory(this.getApplication(), empId))
                .get(OverviewActivityViewModel.class);

        overviewActivityViewModel.getEmployee().observe(this, this::initViews);
        overviewActivityViewModel.getColleagues().observe(this, this::initColleges);

        Button recomBtn = findViewById(R.id.pos_recom);
        recomBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, RecommendationsActivity.class)
                    .putExtra("empId", empId));
        });
    }

    private void initViews(HRData hr) {
        tvFirstName = findViewById(R.id.tv_first_name);
        tvAbsences = findViewById(R.id.tv_absences);
        tvDaysLateLast30 = findViewById(R.id.tv_dayslatelast30);
        tvPosition = findViewById(R.id.tv_position);
        tvSpecialProjects = findViewById(R.id.tv_special_projects);
        tvLastReviewDate = findViewById(R.id.tv_last_review);
        tvSatisfaction = findViewById(R.id.tv_satisfaction);
        satisfactionBar = findViewById(R.id.view_satisfaction);

        final String[] name = hr.getEmployee_Name().split(", ");
        final String firstName = name[0];
        final String lastName = name[1];
        tvFirstName.setText(firstName);

        tvAbsences.setText(hr.getAbsences()+ "");
        tvAbsences.setText(hr.getDaysLateLast30()+ "");

        tvPosition.setText(hr.getPosition());
        tvSpecialProjects.setText(hr.getSpecialProjectsCount() + "");
        tvLastReviewDate.setText(hr.getLastPerformanceReview_Date());
        tvSatisfaction.setText(hr.getEmpSatisfaction() + "/" + 5);

        double percentageSat = hr.getEmpSatisfaction()/5.0;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels - 32;
        satisfactionBar.setLayoutParams(new FrameLayout.LayoutParams(
                (int)(width * percentageSat),
                FrameLayout.LayoutParams.MATCH_PARENT));
    }

    private void initColleges(List<TitleAndDescription> colleagues ) {
        colleaguesLayout = findViewById(R.id.colleges);
        for (int i = 0; i < Math.min(5, colleagues.size()); i++) {
            colleaguesLayout.addView(initEmployeeItem(colleagues.get(i)));
        }
        if (colleagues.size() == 0) {
            TextView tvNoOne = new TextView(this);
            tvNoOne.setText("No colleagues");
            colleaguesLayout.addView(tvNoOne);
        }
        if (colleagues.size() <= 5) return;

        Button btnSeeMore = (Button) getLayoutInflater().inflate(R.layout.btn_see_more, null, false);
        colleaguesLayout.addView(btnSeeMore);

        final ScrollView scrollView = new ScrollView(this);
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);
        final MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(this)
                .setTitle("Colleges")
                .setView(scrollView);
        final AlertDialog dialog = dialogBuilder.create();

        for (final TitleAndDescription colleague: colleagues) {
            linearLayout.addView(initEmployeeItem(colleague));
        }

        btnSeeMore.setOnClickListener(v -> {
            dialog.show();
        });
    }

    private View initEmployeeItem(TitleAndDescription colleague) {
        View view = getLayoutInflater().inflate(R.layout.employee_item_layout, null, false);
        TextView title = view.findViewById(R.id.tv_title);
        TextView initials = view.findViewById(R.id.tv_initials);
        TextView descr = view.findViewById(R.id.tv_descr);

        int randomColor = MaterialColorPalette.getRandomColor("A200");
        MaterialCardView initialsCircle = view.findViewById(R.id.initials_circle);
        initialsCircle.setCardBackgroundColor(randomColor);

        String[] initialsArr = colleague.getEmployee_Name().split(", ");
        if (initialsArr.length > 1)
            initials.setText(initialsArr[0].charAt(0) + "" + initialsArr[1].charAt(0));
        else if (initialsArr.length == 1)
            initials.setText(initialsArr[0].charAt(0) + "");
        else
            initials.setText("-");
        title.setText(colleague.getEmployee_Name());
        descr.setText(colleague.getPosition());

        return view;
    }
}

class IdViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    private final int employeeId;
    private final Application application;

    public IdViewModelFactory(@NonNull Application application, int employeeID) {
        super(application);
        this.application = application;
        this.employeeId = employeeID;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == OverviewActivityViewModel.class) {
            return (T) new OverviewActivityViewModel(application, employeeId);
        }
        return null;
    }
}