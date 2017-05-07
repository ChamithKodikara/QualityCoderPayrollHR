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
        if (basicHourlyRate != null && basicHourlyRate >= 0) {
            double totalOTValue = 0.0;
            if (SalaryConstants.OT_TYPE_REGULAR.equalsIgnoreCase(otType)) {
                totalOTValue = ((basicHourlyRate / 100) * 150) * hoursWorked;
            } else if (SalaryConstants.OT_TYPE_DOUBLE.equalsIgnoreCase(otType)) {
                totalOTValue = ((basicHourlyRate / 100) * 200) * hoursWorked;
            }
            return totalOTValue;
        } else {
            throw new IllegalArgumentException("Given amounts are invalid");
        }
    }
}
