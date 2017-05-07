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
	
	/**
	 * need to change the employee details before run the test case
	 * otherwise it'll add duplicate users
	 */
	/*
	@Test
	public void should_register_employee_When_given_all_details(){
		String empId = "E01001";
		String name = "COOPER PETER";
		String designation = "CLERK III";
		String dob = "12/10/1988";
		String gender = "M";
		String basicSal = "108860.00";
		String epfContribution = "12%";
		String phoneNumber = "711222689";
		String address = "758 Ridge Oak Park";		
		String fileName = "src/main/resources/flatfilebackup2.csv";
		String separator = ",";
		
		EmployeeRegister employeeRegister = new EmployeeRegisterImpl(fileName, separator);
		Boolean isAdded = employeeRegister.addEmployee(empId, name, designation, dob, gender, basicSal, epfContribution, phoneNumber, address);
		
		assertThat(isAdded, is(true));
	}
	*/
	@Test
	public void should_get_employee_when_given_id(){
		String empId = "E00001";
		String fileName = "src/main/resources/flatfilebackup2.csv";
		String separator = ",";
		
		EmployeeRegister employeeRegister = new EmployeeRegisterImpl(fileName, separator);
		Employee employee = employeeRegister.getEmployee(empId);
		
		assertThat(employee.getEmpID(), is(empId));
	}
}