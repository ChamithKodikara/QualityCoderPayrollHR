package com.qualitycoder.payrollhr.model;

/**
 * Created by SANJAYA on 5/7/2017.
 */
public class Leave {
    private String empID;
    private String leaveType;
    private String leaveDate;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }
}
