package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rec_emp")
public class EmpRec {
    @PrimaryKey
    @NonNull
    private int PositionID;
    @NonNull
    private String recommendations;

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public int getPositionID() {
        return PositionID;
    }

    public void setPositionID(int positionID) {
        PositionID = positionID;
    }
}
