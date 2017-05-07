package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.constants.SalaryConstants;

/**
 * @author Chamith
 */
public class PayeeTaxCalculator implements Calculator {
    private Double basicSalary;

    public PayeeTaxCalculator(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double calculate() {
        if (basicSalary != null && basicSalary > 0) {
            if (basicSalary > 125000) {
                return SalaryConstants.PAYEE_TAX_SALARY_125_ABOVE;
            } else if (basicSalary < 125000 && basicSalary >= 100000) {
                return SalaryConstants.PAYEE_TAX_SALARY_100_125;
            } else if (basicSalary < 100000 && basicSalary >= 75000) {
                return SalaryConstants.PAYEE_TAX_SALARY_75_100;
            } else if (basicSalary < 75000 && basicSalary >= 50000) {
                return SalaryConstants.PAYEE_TAX_SALARY_50_75;
            } else if (basicSalary < 50000 && basicSalary >= 30000) {
                return SalaryConstants.PAYEE_TAX_SALARY_30_50;
            } else {
                return 0.0;
            }
        } else {
            throw new IllegalArgumentException("Given amount is invalid");
        }
    }
}
