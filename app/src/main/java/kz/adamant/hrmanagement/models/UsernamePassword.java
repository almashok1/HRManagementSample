package kz.adamant.hrmanagement.models;

public class UsernamePassword {
    private int employeeID;
    private String password;

    public UsernamePassword(int employeeID, String password) {
        this.employeeID = employeeID;
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
