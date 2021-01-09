package kz.adamant.hrmanagement.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.tableview.Cell;
import kz.adamant.hrmanagement.models.tableview.ColumnHeader;
import kz.adamant.hrmanagement.models.tableview.RowHeader;

public class TableViewModel extends ViewModel {
    private List<ColumnHeader> mColumnHeaderModelList;
    private List<RowHeader> mRowHeaderModelList;
    private List<List<Cell>> mCellModelList;


    private List<ColumnHeader> createColumnHeaderModelList() {
        List<ColumnHeader> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeader("EmpID"));
        list.add(new ColumnHeader("Employee_Name"));
        list.add(new ColumnHeader("MarriedID"));
        list.add(new ColumnHeader("MaritalStatusID"));
        list.add(new ColumnHeader("GenderID"));
        list.add(new ColumnHeader("EmpStatusID"));
        list.add(new ColumnHeader("DeptID"));
        list.add(new ColumnHeader("PerfScoreID"));
        list.add(new ColumnHeader("FromDiversityJobFairID"));
        list.add(new ColumnHeader("Salary"));
        list.add(new ColumnHeader("Termd"));
        list.add(new ColumnHeader("PositionID"));
        list.add(new ColumnHeader("Position"));
        list.add(new ColumnHeader("State"));
        list.add(new ColumnHeader("Zip"));
        list.add(new ColumnHeader("DOB"));
        list.add(new ColumnHeader("Sex"));
        list.add(new ColumnHeader("MaritalDesc"));
        list.add(new ColumnHeader("CitizenDesc"));
        list.add(new ColumnHeader("HispanicLatino"));
        list.add(new ColumnHeader("RaceDesc"));
        list.add(new ColumnHeader("DateofHire"));
        list.add(new ColumnHeader("DateofTermination"));
        list.add(new ColumnHeader("TermReason"));
        list.add(new ColumnHeader("EmploymentStatus"));
        list.add(new ColumnHeader("Department"));
        list.add(new ColumnHeader("ManagerID"));
        list.add(new ColumnHeader("ManagerName"));
        list.add(new ColumnHeader("RecruitmentSource"));
        list.add(new ColumnHeader("PerformanceScore"));
        list.add(new ColumnHeader("EngagementSurvey"));
        list.add(new ColumnHeader("EmpSatisfaction"));
        list.add(new ColumnHeader("SpecialProjectsCount"));
        list.add(new ColumnHeader("LastPerformanceReview_Date"));
        list.add(new ColumnHeader("DaysLateLast30"));
        list.add(new ColumnHeader("Absences"));
        return list;
    }

    private List<List<Cell>> createCellModelList(List<HRData> empList) {
        List<List<Cell>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for (int i = 0; i < empList.size(); i++) {
            HRData emp = empList.get(i);

            List<Cell> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new Cell("1-" + i, emp.getEmpID()));
            list.add(new Cell("2-" + i, emp.getEmployee_Name()));
            list.add(new Cell("3-" + i, emp.getMarriedID()));
            list.add(new Cell("4-" + i, emp.getMaritalStatusID()));
            list.add(new Cell("5-" + i, emp.getGenderID()));
            list.add(new Cell("6-" + i, emp.getEmpStatusID()));
            list.add(new Cell("7-" + i, emp.getDeptID()));
            list.add(new Cell("8-" + i, emp.getPerfScoreID()));
            list.add(new Cell("9-" + i, emp.getFromDiversityJobFairID()));
            list.add(new Cell("10-" + i, emp.getSalary()));
            list.add(new Cell("11-" + i, emp.getTermd()));
            list.add(new Cell("12-" + i, emp.getPositionID()));
            list.add(new Cell("13-" + i, emp.getPosition()));
            list.add(new Cell("14-" + i, emp.getState()));
            list.add(new Cell("15-" + i, emp.getZip()));
            list.add(new Cell("16-" + i, emp.getDOB()));
            list.add(new Cell("17-" + i, emp.getSex()));
            list.add(new Cell("18-" + i, emp.getMaritalDesc()));
            list.add(new Cell("19-" + i, emp.getCitizenDesc()));
            list.add(new Cell("20-" + i, emp.getHispanicLatino()));
            list.add(new Cell("21-" + i, emp.getRaceDesc()));
            list.add(new Cell("22-" + i, emp.getDateofHire()));
            list.add(new Cell("23-" + i, emp.getDateofTermination()));
            list.add(new Cell("24-" + i, emp.getTermReason()));
            list.add(new Cell("25-" + i, emp.getEmploymentStatus()));
            list.add(new Cell("26-" + i, emp.getDepartment()));
            list.add(new Cell("27-" + i, emp.getManagerID()));
            list.add(new Cell("28-" + i, emp.getManagerName()));
            list.add(new Cell("29-" + i, emp.getRecruitmentSource()));
            list.add(new Cell("30-" + i, emp.getPerformanceScore()));
            list.add(new Cell("31-" + i, emp.getEngagementSurvey()));
            list.add(new Cell("32-" + i, emp.getEmpSatisfaction()));
            list.add(new Cell("33-" + i, emp.getSpecialProjectsCount()));
            list.add(new Cell("34-" + i, emp.getLastPerformanceReview_Date()));
            list.add(new Cell("35-" + i, emp.getDaysLateLast30()));
            list.add(new Cell("36-" + i, emp.getAbsences()));

            // Add
            lists.add(list);
        }

        return lists;
    }

    private List<RowHeader> createRowHeaderList(int size) {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // In this example, Row headers just shows the index of the TableView List.
            list.add(new RowHeader(String.valueOf(i + 1)));
        }
        return list;
    }

    public List<ColumnHeader> getColumHeaderModeList() {
        return mColumnHeaderModelList;
    }

    public List<RowHeader> getRowHeaderModelList() {
        return mRowHeaderModelList;
    }

    public List<List<Cell>> getCellModelList() {
        return mCellModelList;
    }


    public void generateListForTableView(List<HRData> users) {
        mColumnHeaderModelList = createColumnHeaderModelList();
        mCellModelList = createCellModelList(users);
        mRowHeaderModelList = createRowHeaderList(users.size());
    }
}
