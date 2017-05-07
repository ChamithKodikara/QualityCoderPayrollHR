package com.qualitycoder.payrollhr.model;

/**
 * Created by SANJAYA on 5/7/2017.
 */
public class Attendance {

    private String empID;
    private String attendanceDate;
    private String attendanceIn;
    private String attendanceOut;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getAttendanceIn() {
        return attendanceIn;
    }

    public void setAttendanceIn(String attendanceIn) {
        this.attendanceIn = attendanceIn;
    }

    public String getAttendanceOut() {
        return attendanceOut;
    }

    public void setAttendanceOut(String attendanceOut) {
        this.attendanceOut = attendanceOut;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
