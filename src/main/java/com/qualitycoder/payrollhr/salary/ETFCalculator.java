package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;
import com.qualitycoder.payrollhr.constants.SalaryConstants;

/**
 * @author Chamith
 */
public class ETFCalculator implements Calculator {
    private Double basicSalary;

    public ETFCalculator(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double calculate() {
        if (basicSalary != null && basicSalary > 0) {
            return (basicSalary / 100) * SalaryConstants.ETF_EMPLOYER_CONTRIBUTION;
        } else {
            throw new IllegalArgumentException("Given amount is invalid for ETF Calculation");
        }
    }
}
