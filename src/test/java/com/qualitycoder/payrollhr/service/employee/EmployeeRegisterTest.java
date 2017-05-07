package com.qualitycoder.payrollhr.service.employee;

import java.util.List;

import org.junit.Test;

import com.qualitycoder.payrollhr.model.Employee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EmployeeRegisterTest {
	
	@Test
	public void should_import_all_data_from_CSV_When_FileExist(){
		String fileName = "";
		EmployeeRegister employeeRegister = new EmployeeRegister();
		List<Employee> employees = employeeRegister.importDataFileCSV(fileName);
		
	}
	
}