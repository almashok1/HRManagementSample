package kz.adamant.hrmanagement.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kz.adamant.hrmanagement.models.Admin;
import kz.adamant.hrmanagement.models.EmpRec;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.PosRec;

@Database(entities = {HRData.class, Admin.class, PosRec.class, EmpRec.class}, version = 1)
public abstract class HRDatabase extends RoomDatabase {
    private static HRDatabase instance;

    public abstract HRDao hrDao();
    public abstract AdminDao adminDao();
    public abstract RecDao recDao();

    public static synchronized HRDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HRDatabase.class, "hr.db")
                    .createFromAsset("databases/hr.db")
                    .build();
        }
        return instance;
    }
}
