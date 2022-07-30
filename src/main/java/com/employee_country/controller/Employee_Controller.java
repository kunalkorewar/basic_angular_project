package com.employee_country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee_country.entities.Country;
import com.employee_country.entities.Employee;
import com.employee_country.service.Employee_Country_Service;

@RestController
public class Employee_Controller {

	@Autowired
	private Employee_Country_Service service;

	List<Employee> employees;

//1
	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> allEmployee() {

		employees = service.employeeList();

		if (!employees.isEmpty()) {

			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
	}

//2
	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {

		String string = service.addEmployee(employee);

		if (string.equals("Employee Added Successfully..")) {
			
			return new ResponseEntity<String>(string, HttpStatus.OK);
			
		} else {

			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


//3
	@PutMapping("updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {

		String string = service.updateEmployee(employee);

		if (string.equals("EmployeeId : " + employee.getId() + " Updated Successfully..")) {
			
			//if id update then return with string and 200 ok status
			
			return new ResponseEntity<String>(string, HttpStatus.OK);
		
		} else if (string.equals("Something Went Wrong..")) {
			
			//if exception come due to tx.commit() or session.update()
			//then it will return with string and 500 status
			
			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		
		} else {
			
			//if id is not present then return only 204 no_contant
			//we cant return string with 204 no_contant
			//here we send but still it will not show on console of postman..
			
			return new ResponseEntity<String>(string, HttpStatus.NO_CONTENT);

		}
	}
//4
	@DeleteMapping("deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {

		String string = service.deleteEmployeeById(id);

		if (string.equals("EmployeeId : " + id + " Deleted Successfully..")) {
			
			return new ResponseEntity<String>(string, HttpStatus.OK);
		
		} else if (string.equals("Something Went Wrong..")) {
			
			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		
		} else {
			
			return new ResponseEntity<String>(string, HttpStatus.NO_CONTENT);

		}
	}

//5
	@GetMapping("getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {

		Employee employee = service.getEmployeeById(id);

		if (employee != null) {
			
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		} else {
			
			return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
		
		}
	}
}
