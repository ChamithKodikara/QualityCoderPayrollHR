package com.qualitycoder.payrollhr.service.employee;

import java.util.List;

import org.junit.Test;

import com.qualitycoder.payrollhr.model.Employee;
import com.qualitycoder.payrollhr.service.employee.impl.EmployeeRegisterImpl;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EmployeeRegisterTest {
	
	@Test
	public void should_import_all_employees_from_CSV_When_File_Rows_Exist(){
		String fileName = "src/main/resources/flatfilebackup2.csv";
		String separator = ",";
		
		EmployeeRegister employeeRegister = new EmployeeRegisterImpl(fileName, separator);
		List<Employee> employees = employeeRegister.importDataFileCSV();
		
		assertThat(employees.size(), not(0));
		Employee firstEmp = employees.get(0);
		assertThat(firstEmp.getEmpID(), is("E00001"));
	}	
}