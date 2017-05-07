package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;
import com.qualitycoder.payrollhr.model.Employee;
import com.qualitycoder.payrollhr.model.OTDetail;

/**
 * @author Chamith
 */
public class SalaryGeneratorImpl implements SalaryGenerator {
    @Override
    public double generate(Employee employee, OTDetail otDetail) {
        Calculator epfCalculator = new EPFCalculator(employee.getBasicSalary(), employee.getEpfContribution());
        Calculator etfCalculator = new ETFCalculator(employee.getBasicSalary());
        return 0;
    }
}
