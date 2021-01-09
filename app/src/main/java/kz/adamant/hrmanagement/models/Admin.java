package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "admin_table")
public class Admin {
    @NonNull
    @PrimaryKey
    private String login;
    @NonNull
    private String password;

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
