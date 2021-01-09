package kz.adamant.hrmanagement.view.hrmenu.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.evrencoskun.tableview.TableView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.Department;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.Position;
import kz.adamant.hrmanagement.models.tableview.TableViewListener;
import kz.adamant.hrmanagement.view.adapters.TableViewAdapter;
import kz.adamant.hrmanagement.view.hrmenu.RecommendationsActivity;
import kz.adamant.hrmanagement.viewmodel.AdminPanelViewModel;

public class AdminPanelActivity extends AppCompatActivity {
    private AdminPanelViewModel adminPanelViewModel;
    private ChipGroup depChipGroup;
    private ChipGroup posChipGroup;

    private TableViewAdapter mTableAdapter;
    private TableView mTableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        adminPanelViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AdminPanelViewModel.class);
        adminPanelViewModel.getDepartments().observe(this, this::initDepChips);
        adminPanelViewModel.getPositions().observe(this, this::initPosChips);
        adminPanelViewModel.getEmployeesByPosition().observe(this, this::initEmployees);

        mTableView = findViewById(R.id.table_view);
        initializeTableView();


        findViewById(R.id.recom).setOnClickListener(v -> {
            if (adminPanelViewModel.getPosIdSelected().getValue() != null)
                startActivity(new Intent(this, RecommendationsActivity.class).putExtra("posId", adminPanelViewModel.getPosIdSelected().getValue()));
        });
    }

    private void initEmployees(List<HRData> hrData) {
        mTableAdapter.setHRDataList(hrData);
    }

    private void initPosChips(List<Position> positions) {
        posChipGroup = findViewById(R.id.pos_chip_group);
        posChipGroup.setSingleSelection(true);
        posChipGroup.removeAllViews();
        for (final Position pos: positions) {
            Chip chip = new Chip(this, null, R.style.Widget_MaterialComponents_Chip_Choice);
            chip.setChipBackgroundColor(AppCompatResources.getColorStateList(this, R.color.chip_state_list));
            chip.setText(pos.getPosition());
            chip.setCheckable(true);
            chip.setOnClickListener(v -> {
                posChipGroup.clearCheck();
                chip.setChecked(true);
                adminPanelViewModel.getPosIdSelected().setValue(pos.getPositionID());
            });
            posChipGroup.addView(chip);
        }
    }

    private void initDepChips(List<Department> departments) {
        depChipGroup = findViewById(R.id.dep_chip_group);
        depChipGroup.setSingleSelection(true);

        for (final Department deps: departments) {
            Chip chip = new Chip(this, null, R.style.Widget_MaterialComponents_Chip_Choice);
            chip.setText(deps.getDepartment());
            chip.setChipBackgroundColor(AppCompatResources.getColorStateList(this, R.color.chip_state_list));
            chip.setCheckable(true);
            chip.setOnClickListener(v -> {
                depChipGroup.clearCheck();
                chip.setChecked(true);
                adminPanelViewModel.getDepIdSelected().setValue(deps.getDepID());
            });
            depChipGroup.addView(chip);
        }
    }

    private void initializeTableView(){
        // Create TableView Adapter
        mTableAdapter = new TableViewAdapter();
        mTableView.setAdapter(mTableAdapter);

        // Create listener
        mTableView.setTableViewListener(new TableViewListener(mTableView));
    }
}