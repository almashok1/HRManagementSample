package kz.adamant.hrmanagement.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="hr_table")
public class HRData {
    @NonNull
    private String Employee_Name;
    @PrimaryKey
    @NonNull
    private int EmpID;
    @NonNull
    private int MarriedID;
    @NonNull
    private int MaritalStatusID;
    @NonNull
    private int GenderID;
    @NonNull
    private int EmpStatusID;
    @NonNull
    private int DeptID;
    @NonNull
    private int PerfScoreID;
    @NonNull
    private int FromDiversityJobFairID;
    @NonNull
    private int Salary;
    @NonNull
    private int Termd;
    @NonNull
    private int PositionID;
    @NonNull
    private String Position;
    @NonNull
    private String State;
    @NonNull
    private int Zip;
    @NonNull
    private String DOB;
    @NonNull
    private String Sex;
    @NonNull
    private String MaritalDesc;
    @NonNull
    private String CitizenDesc;
    @NonNull
    private String HispanicLatino;
    @NonNull
    private String RaceDesc;
    @NonNull
    private String DateofHire;

    private String DateofTermination;

    private Integer ManagerID;

    @NonNull
    private String TermReason;
    @NonNull
    private String EmploymentStatus;
    @NonNull
    private String Department;
    @NonNull
    private String ManagerName;
    @NonNull
    private String RecruitmentSource;
    @NonNull
    private String PerformanceScore;
    @NonNull
    private double EngagementSurvey;
    @NonNull
    private int EmpSatisfaction;
    @NonNull
    private int SpecialProjectsCount;
    @NonNull
    private String LastPerformanceReview_Date;
    @NonNull
    private int DaysLateLast30;
    @NonNull
    private int Absences;


    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        EmpID = empID;
    }

    public int getMarriedID() {
        return MarriedID;
    }

    public void setMarriedID(int marriedID) {
        MarriedID = marriedID;
    }

    public int getMaritalStatusID() {
        return MaritalStatusID;
    }

    public void setMaritalStatusID(int maritalStatusID) {
        MaritalStatusID = maritalStatusID;
    }

    public int getGenderID() {
        return GenderID;
    }

    public void setGenderID(int genderID) {
        GenderID = genderID;
    }

    public int getEmpStatusID() {
        return EmpStatusID;
    }

    public void setEmpStatusID(int empStatusID) {
        EmpStatusID = empStatusID;
    }

    public int getDeptID() {
        return DeptID;
    }

    public void setDeptID(int deptID) {
        DeptID = deptID;
    }

    public int getPerfScoreID() {
        return PerfScoreID;
    }

    public void setPerfScoreID(int perfScoreID) {
        PerfScoreID = perfScoreID;
    }

    public int getFromDiversityJobFairID() {
        return FromDiversityJobFairID;
    }

    public void setFromDiversityJobFairID(int fromDiversityJobFairID) {
        FromDiversityJobFairID = fromDiversityJobFairID;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getTermd() {
        return Termd;
    }

    public void setTermd(int termd) {
        Termd = termd;
    }

    public int getPositionID() {
        return PositionID;
    }

    public void setPositionID(int positionID) {
        PositionID = positionID;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZip() {
        return Zip;
    }

    public void setZip(int zip) {
        Zip = zip;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getMaritalDesc() {
        return MaritalDesc;
    }

    public void setMaritalDesc(String maritalDesc) {
        MaritalDesc = maritalDesc;
    }

    public String getCitizenDesc() {
        return CitizenDesc;
    }

    public void setCitizenDesc(String citizenDesc) {
        CitizenDesc = citizenDesc;
    }

    public String getHispanicLatino() {
        return HispanicLatino;
    }

    public void setHispanicLatino(String hispanicLatino) {
        HispanicLatino = hispanicLatino;
    }

    public String getRaceDesc() {
        return RaceDesc;
    }

    public void setRaceDesc(String raceDesc) {
        RaceDesc = raceDesc;
    }

    public String getDateofHire() {
        return DateofHire;
    }

    public void setDateofHire(String dateofHire) {
        DateofHire = dateofHire;
    }

    public String getDateofTermination() {
        return DateofTermination;
    }

    public void setDateofTermination(String dateofTermination) {
        DateofTermination = dateofTermination;
    }

    public String getTermReason() {
        return TermReason;
    }

    public void setTermReason(String termReason) {
        TermReason = termReason;
    }

    public String getEmploymentStatus() {
        return EmploymentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        EmploymentStatus = employmentStatus;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public Integer getManagerID() {
        return ManagerID;
    }

    public void setManagerID(Integer managerID) {
        ManagerID = managerID;
    }

    public String getRecruitmentSource() {
        return RecruitmentSource;
    }

    public void setRecruitmentSource(String recruitmentSource) {
        RecruitmentSource = recruitmentSource;
    }

    public String getPerformanceScore() {
        return PerformanceScore;
    }

    public void setPerformanceScore(String performanceScore) {
        PerformanceScore = performanceScore;
    }

    public double getEngagementSurvey() {
        return EngagementSurvey;
    }

    public void setEngagementSurvey(double engagementSurvey) {
        EngagementSurvey = engagementSurvey;
    }

    public int getSpecialProjectsCount() {
        return SpecialProjectsCount;
    }

    public void setSpecialProjectsCount(int specialProjectsCount) {
        SpecialProjectsCount = specialProjectsCount;
    }

    public String getLastPerformanceReview_Date() {
        return LastPerformanceReview_Date;
    }

    public void setLastPerformanceReview_Date(String lastPerformanceReview_Date) {
        LastPerformanceReview_Date = lastPerformanceReview_Date;
    }

    public int getDaysLateLast30() {
        return DaysLateLast30;
    }

    public void setDaysLateLast30(int daysLateLast30) {
        DaysLateLast30 = daysLateLast30;
    }

    public int getAbsences() {
        return Absences;
    }

    public void setAbsences(int absences) {
        Absences = absences;
    }

    public int getEmpSatisfaction() {
        return EmpSatisfaction;
    }

    public void setEmpSatisfaction(int empSatisfaction) {
        EmpSatisfaction = empSatisfaction;
    }
}
