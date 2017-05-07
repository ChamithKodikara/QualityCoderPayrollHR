package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.model.Employee;
import com.qualitycoder.payrollhr.model.OTDetail;
import com.qualitycoder.payrollhr.service.employee.EmployeeRegister;
import com.qualitycoder.payrollhr.service.employee.impl.EmployeeRegisterImpl;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author Chamith
 */
public class SalaryGeneratorTest {
    @Test
    public void shouldGenerateSalaryWhenEmployeeDetailGiven() {
        EmployeeRegister register = new EmployeeRegisterImpl("src/main/resources/flatfilebackup2.csv", ",");
        Employee employee = register.getEmployee("E00001");
        OTDetail otDetail = new OTDetail("E00001", 100.00, 3.0, 5.0);
        SalaryGenerator salaryGenerator = new SalaryGeneratorImpl();
        double salary = salaryGenerator.generate(employee.getBasicSalary(), employee.getEpfContribution(), otDetail);
        assertThat(salary, is(91924.9));
    }
}

