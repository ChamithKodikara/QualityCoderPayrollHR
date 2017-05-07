package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.model.OTDetail;

/**
 * @author Chamith
 */
public interface SalaryGenerator {
    double generate(double basicSalary, double epfContribution, OTDetail otDetail);
}
