package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

public class Position {
    @NonNull
    private int PositionID;
    @NonNull
    private String Position;
    @NonNull
    private double AverageSalary;

    public double getAverageSalary() {
        return AverageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        AverageSalary = averageSalary;
    }
    public int getPositionID() {
        return PositionID;
    }

    public void setPositionID(int positionID) {
        PositionID = positionID;
    }

    @NonNull
    public String getPosition() {
        return Position;
    }

    public void setPosition(@NonNull String position) {
        Position = position;
    }


}
