package com.employee_country.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_country.dao.Employee_Country_Dao;
import com.employee_country.entities.Country;
import com.employee_country.entities.Employee;

@Service
public class Employee_Country_Service {

	@Autowired
	private Employee_Country_Dao dao;

	List<Country> countries;
	List<Employee> employees;
	
	
//coding for country start

//1
	public List<Country> countryList() {

		countries = dao.countryList();

		return countries;
	}

	/*
	 * public ArrayList<Country> addCountry(Country[] country) {
	 * 
	 * Country country3 = null;
	 * 
	 * ArrayList<Country> list = new ArrayList<>();
	 * 
	 * for (Country country2 : country) {
	 * 
	 * country3 = dao.addCountry(country2);
	 * 
	 * Country coun = new Country();
	 * 
	 * coun = country3;
	 * 
	 * list.add(coun);
	 * 
	 * } return list;
	 * 
	 * }
	 */

	
//2
	public String addCountry(Country country) {

		String string = dao.addCountry(country);

		return string;

	}

//3	
	public String updateCountry(Country country) {

		String string = dao.updateCountry(country);

		return string;
	}
	
	
//4	
	public String deleteCountryById(Integer cid) {

		String string = dao.deleteCountryById(cid);

		return string;
	}

//5	
	public Country getCountryById(Integer cid) {

		Country country = dao.getCountryById(cid);

		return country;
	}


// coding for employee start


//6
	public List<Employee> employeeList() {

		employees = dao.employeeList();

		return employees;
	}
	
	
//7
	public String addEmployee(Employee employee) {

		String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		employee.setCreateddtm(date);// both same at time of save
		employee.setUpdateddtm(date);

		String string = dao.addEmployee(employee);

		return string;
	}

//8	
	public String updateEmployee(Employee employee) {

		String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		employee.setUpdateddtm(date);//for update date

		String string = dao.updateEmployee(employee);

		return string;
	}
	
//9
	public String deleteEmployeeById(Integer id) {

		String string = dao.deleteEmployeeById(id);

		return string;
	}
	
	
//10
	public Employee getEmployeeById(Integer id) {

		Employee employee = dao.getEmployeeById(id);

		return employee;
	}

	/*
	 * public ArrayList<Employee> addEmployee(Employee[] employees) {
	 * 
	 * ArrayList<Employee> list = new ArrayList<>();
	 * 
	 * System.out.println(list);
	 * 
	 * for (Employee employee : employees) {
	 * 
	 * String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
	 * Date()); Date date = null; try { date = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1); } catch (ParseException
	 * e) { e.printStackTrace(); }
	 * 
	 * employee.setCreateddtm(date);// both same at time of save
	 * employee.setUpdateddtm(date);
	 * 
	 * Employee emp = dao.addEmployee(employee);
	 * 
	 * Employee empl = new Employee();
	 * 
	 * empl = emp;
	 * 
	 * list.add(empl); }
	 * 
	 * return list; }
	 */

}
