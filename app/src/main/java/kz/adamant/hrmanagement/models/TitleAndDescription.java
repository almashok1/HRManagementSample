package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName="hr_table")
public class TitleAndDescription {
    @NonNull
    private String Employee_Name;
    @NonNull
    private String Position;

    @NonNull
    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(@NonNull String employee_Name) {
        Employee_Name = employee_Name;
    }

    @NonNull
    public String getPosition() {
        return Position;
    }

    public void setPosition(@NonNull String position) {
        Position = position;
    }
}
