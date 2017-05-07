package com.qualitycoder.payrollhr.model;

/**
 * @author Chamith
 */
public class OTDetail {
    private String empID;
    private Double basicHourlyRate;
    private Double regularOTHours;
    private Double doubleOTHours;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public Double getRegularOTHours() {
        return regularOTHours;
    }

    public void setRegularOTHours(Double regularOTHours) {
        this.regularOTHours = regularOTHours;
    }

    public Double getDoubleOTHours() {
        return doubleOTHours;
    }

    public void setDoubleOTHours(Double doubleOTHours) {
        this.doubleOTHours = doubleOTHours;
    }

    public Double getBasicHourlyRate() {
        return basicHourlyRate;
    }

    public void setBasicHourlyRate(Double basicHourlyRate) {
        this.basicHourlyRate = basicHourlyRate;
    }
}
