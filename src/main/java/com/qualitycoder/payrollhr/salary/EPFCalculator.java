package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;

/**
 * @author Chamith
 */
public class EPFCalculator implements Calculator {

    private Double basicSalary;

    public EPFCalculator(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double calculate() {
        if (basicSalary != null && basicSalary > 0) {
            return (basicSalary / 100) * 8 + (basicSalary / 100) * 12;
        } else {
            throw new IllegalArgumentException("Given amount is invalid");
        }
    }
}
