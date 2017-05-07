package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;
import com.qualitycoder.payrollhr.constants.SalaryConstants;

/**
 * @author Chamith
 */
public class OTCalculator implements Calculator {
    private Double basicHourlyRate;
    private Double hoursWorked;
    private String otType;

    public OTCalculator(Double basicHourlyRate, Double hoursWorked, String otType) {
        this.basicHourlyRate = basicHourlyRate;
        this.hoursWorked = hoursWorked;
        this.otType = otType;
    }

    public double calculate() {
        if (basicHourlyRate != null && otType != null && hoursWorked != null && hoursWorked >= 0 && basicHourlyRate >= 0) {
            double totalOTValue = 0.0;
            if (SalaryConstants.OT_TYPE_REGULAR.equalsIgnoreCase(otType)) {
                if (hoursWorked <= 4) {
                    totalOTValue = ((basicHourlyRate / 100) * 150) * hoursWorked;
                } else {
                    throw new IllegalArgumentException("Invalid Time for working hours");
                }
            } else if (SalaryConstants.OT_TYPE_DOUBLE.equalsIgnoreCase(otType)) {
                if (hoursWorked <= 8) {
                    totalOTValue = ((basicHourlyRate / 100) * 200) * hoursWorked;
                } else {
                    throw new IllegalArgumentException("Invalid Time for working hours");
                }
            }
            return totalOTValue;
        } else {
            throw new IllegalArgumentException("Given values are invalid for OT calculation");
        }
    }
}
