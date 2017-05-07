package com.qualitycoder.payrollhr.service.employee.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qualitycoder.payrollhr.model.Employee;
import com.qualitycoder.payrollhr.service.employee.EmployeeRegister;

public class EmployeeRegisterImpl implements EmployeeRegister {
	
	Logger logger = Logger.getLogger(EmployeeRegisterImpl.class);
	
	private String fileName;
	private String separator;
	
	public EmployeeRegisterImpl(String fileName, String separator) {
		this.fileName = fileName;
		this.separator = separator;
	}

	@Override
	public List<Employee> importDataFileCSV() {
		List<Employee> employees = new ArrayList<Employee>();
	    try{
	    	 BufferedReader reader = new BufferedReader(new FileReader(fileName));
		     String Headerline = reader.readLine();
		     logger.debug(Headerline);
		     String line;
		     DateFormat format = new SimpleDateFormat("MM/dd/yyy");
		     while((line = reader.readLine()) != null){
				 String[] lineArr = line.split(separator);
				 Employee employee = new Employee();
				 employee.setEmpID(lineArr[0]);
				 employee.setEmpName(lineArr[1]);
				 employee.setDesignation(lineArr[2]);
				 if(lineArr[3] != null && lineArr[3].trim().length() > 0){
					 employee.setDob(format.parse(lineArr[3]));
				 }
				 employee.setGender(lineArr[4]);
				 if(lineArr[5] != null && lineArr[5].trim().length() > 0){
					 employee.setBasicSalary(Double.parseDouble(lineArr[5]));
				 }
				 if(lineArr[6] != null && lineArr[6].trim().length() > 0){
					 employee.setEpfContribution(Double.parseDouble(lineArr[6].replace("%", "")));
				 }
				 employee.setPhoneNo(lineArr[7]);
				 employee.setAddress(lineArr[8]);
				 employees.add(employee);
		     }
		     reader.close();
	    }
	    catch(ParseException ex){
	    	logger.error(ex.getMessage());	    	 
	    }
	    catch(FileNotFoundException ex){
	    	logger.error(" File not found in the given path "+fileName);
	    	logger.error(ex.getMessage());
	    }
	    catch (IOException ex) {
	    	logger.error(ex.getMessage());
	    }
		return employees;
	}

	@Override
	public Boolean addEmployee(String empId, String name, String designation,
			String dob, String gender, String basicSal, String epfContribution,
			String phoneNumber, String address) {
		Boolean isAdded = false;
		try {
			Writer output = new BufferedWriter(new FileWriter(fileName, true));
			StringBuilder employeeBuilder = new StringBuilder();
			employeeBuilder.append("\n").append(empId).append(separator)
				.append(name).append(separator)
				.append(designation).append(separator)
				.append(dob).append(separator)
				.append(gender).append(separator)
				.append(basicSal).append(separator)
				.append(epfContribution).append(separator)
				.append(phoneNumber).append(separator)
				.append(address);
			output.append(employeeBuilder.toString());
			output.close();
			isAdded = true;
		} catch (IOException ex) {
			logger.error(" error while appending new employee");
			logger.error(ex.getMessage());
		}
		return isAdded;
	}

	@Override
	public Employee getEmployee(String empId) {
		Employee employee = new Employee();
	    try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String Headerline = reader.readLine();
			logger.debug(Headerline);
			String line;
			DateFormat format = new SimpleDateFormat("MM/dd/yyy");
			while((line = reader.readLine()) != null){
				 String[] lineArr = line.split(separator);
				 if(empId.equalsIgnoreCase(lineArr[0])){
					 employee.setEmpID(lineArr[0]);					 
					 employee.setEmpName(lineArr[1]);
					 employee.setDesignation(lineArr[2]);
					 if(lineArr[3] != null && lineArr[3].trim().length() > 0){
						 employee.setDob(format.parse(lineArr[3]));
					 }
					 employee.setGender(lineArr[4]);
					 if(lineArr[5] != null && lineArr[5].trim().length() > 0){
						 employee.setBasicSalary(Double.parseDouble(lineArr[5]));
					 }
					 if(lineArr[6] != null && lineArr[6].trim().length() > 0){
						 employee.setEpfContribution(Double.parseDouble(lineArr[6].replace("%", "")));
					 }
					 employee.setPhoneNo(lineArr[7]);
					 employee.setAddress(lineArr[8]);
					 break;
				 }
			 }
			 reader.close();
	    }
		catch(ParseException ex){
			logger.error(ex.getMessage());	    	 
		}
		catch(FileNotFoundException ex){
		   	logger.error(" File not found in the given path "+fileName);
		   	logger.error(ex.getMessage());
		}
		catch (IOException ex) {
		   	logger.error(ex.getMessage());
		}
	    return employee;
	}	
}