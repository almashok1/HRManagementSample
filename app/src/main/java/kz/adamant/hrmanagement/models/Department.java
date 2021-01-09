package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "hr_table")
public class Department {
    @NonNull
    private int DeptID;
    @NonNull
    private String Department;

    public int getDepID() {
        return DeptID;
    }

    public void setDeptID(int depID) {
        DeptID = depID;
    }

    @NonNull
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(@NonNull String department) {
        Department = department;
    }

}
