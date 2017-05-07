package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.model.Employee;
import com.qualitycoder.payrollhr.model.OTDetail;

/**
 * @author Chamith
 */
public interface SalaryGenerator {
    double generate(Employee employee, OTDetail otDetail);
}
