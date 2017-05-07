package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;
import com.qualitycoder.payrollhr.constants.SalaryConstants;

/**
 * @author Chamith
 */
public class EPFCalculator implements Calculator {

    private Double basicSalary;
    private Double epfContribution;

    public EPFCalculator(Double basicSalary, Double epfContribution) {
        this.basicSalary = basicSalary;
        this.epfContribution = epfContribution;
    }

    @Override
    public double calculate() {
        if ((epfContribution != null && epfContribution > 0) && (basicSalary != null && basicSalary > 0)) {
            return (basicSalary / 100) * epfContribution + (basicSalary / 100) * SalaryConstants.EPF_EMPLOYER_CONTRIBUTION;
        } else {
            throw new IllegalArgumentException("Given amounts are invalid for EPF Calculation");
        }
    }
}
