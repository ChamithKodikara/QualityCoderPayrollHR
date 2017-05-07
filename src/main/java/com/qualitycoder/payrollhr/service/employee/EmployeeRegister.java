package com.qualitycoder.payrollhr.service.employee;

import java.util.List;

import com.qualitycoder.payrollhr.model.Employee;

public interface EmployeeRegister {

	public List<Employee> importDataFileCSV();

	public Boolean addEmployee(String empId, String name, String designation,
			String dob, String gender, String basicSal, String epfContribution,
			String phoneNumber, String address);

}
