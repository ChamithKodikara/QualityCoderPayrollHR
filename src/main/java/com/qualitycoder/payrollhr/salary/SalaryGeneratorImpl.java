package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.Calculator;
import com.qualitycoder.payrollhr.constants.SalaryConstants;
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
        Calculator payeeTaxCalculator = new PayeeTaxCalculator(employee.getBasicSalary());
        Calculator regularOTCalculator = new OTCalculator(otDetail.getBasicHourlyRate(), otDetail.getRegularOTHours(), SalaryConstants.OT_TYPE_REGULAR);
        Calculator doubleOTCalculator = new OTCalculator(otDetail.getBasicHourlyRate(), otDetail.getDoubleOTHours(), SalaryConstants.OT_TYPE_DOUBLE);
        return 0;
    }
}
