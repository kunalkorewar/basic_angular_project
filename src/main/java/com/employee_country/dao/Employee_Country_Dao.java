package com.employee_country.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee_country.entities.Country;
import com.employee_country.entities.Employee;

@Repository
public class Employee_Country_Dao {

	@Autowired
	SessionFactory factory;

	List<Country> countries;
	List<Employee> employees;

	public Employee_Country_Dao() {

	}



	@PostConstruct
	public void init() {

		getLatestData();
		getLatestDataOfEmployee();

	}

	
//coding for country start	
	
	
	public void getLatestData() {

		Session session = factory.openSession();

		try {

			// Query<Country> query = session.createQuery("select cname from Country");

			Query<Country> query = session.createQuery("from Country");

			countries = query.list();

			/*
			 * Criteria criteria = session.createCriteria(Country.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.property("cname"));
			 * 
			 * countries = criteria.setProjection(pl).list();
			 */

		} catch (Exception e) {
			System.out.println("list is empty");
		} finally {

			session.close();
		}

	}
	


//1	
	public List<Country> countryList() {

		getLatestData();

		return countries;
	}

	/*
	 * public Country addCountry(Country country) { System.out.println(country);
	 * Session session = factory.openSession(); Transaction tx =
	 * session.beginTransaction();
	 * 
	 * int count = 0;
	 * 
	 * try { session.save(country); tx.commit(); count++;
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println(count + " : save , " +
	 * "exception handle in addCountry.."); return null;
	 * 
	 * } finally {
	 * 
	 * session.close(); }
	 * 
	 * return country; }
	 */

//2	
	public String addCountry(Country country) {
		System.out.println(country);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String string = "Data rollBack..";
		try {
			session.save(country);
			tx.commit();
			string = "Country Added Successfully..";

		} catch (Exception e) {

			System.out.println("exception handle in addCountry..");
			e.printStackTrace();

		} finally {

			session.close();
		}

		return string;
	}
	
//3
	public String updateCountry(Country country) {

		getLatestData();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String string = "CountryId : " + country.getCid() + " is Not Present..";
		;

		Country cnt = null;
		for (Country coun : countries) {

			if (coun.getCid() == country.getCid()) {

				cnt = coun;
				break;
			}
		}

		if (cnt != null) {

			try {
				Country cou = session.get(Country.class, cnt.getCid());

				/*
				 * session.delete(cou); session.save(country);
				 */
				cou.setCname(country.getCname());
				session.update(cou);
				tx.commit();
				string = "CountryId : " + country.getCid() + " Updated Successfully..";

			} catch (Exception e) {

				System.out.println("exception handle in update..");
				e.printStackTrace();
				string = "Something Went Wrong..";

			} finally {
				session.close();
			}
		}

		return string;
	}
	
	
//4	
	public String deleteCountryById(Integer cid) {

		getLatestData();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Country cnt = null;

		String string = "CountryId : " + cid + " is Not Present..";

		for (Country country : countries) {

			if (country.getCid() == cid) {

				cnt = country;
				break;
			}
		}

		if (cnt != null) {

			try {
				Country country = session.get(Country.class, cnt.getCid());

				session.delete(country);
				tx.commit();

				string = "CountryId : " + cid + " Deleted Successfully..";

			} catch (Exception e) {

				System.out.println("exception handle in delete..");
				e.printStackTrace();
				string = "Something Went Wrong..";

			} finally {
				session.close();
			}

		}

		return string;
	}

	
//5	
	public Country getCountryById(Integer cid) {
		getLatestData();

		Country cnt = null;

		for (Country country : countries) {
			if (country.getCid() == cid) {
				cnt = country;
				break;
			}
		}

		return cnt;
	}

//coding for employee start


	public void getLatestDataOfEmployee() {

		Session session = factory.openSession();
		try {
			Query<Employee> query = session.createQuery("from Employee");

			employees = query.list();
		} catch (Exception e) {

			System.out.println("employee list is empty");
			e.printStackTrace();

		} finally {
			session.close();
		}

	}
	

//6	
	public List<Employee> employeeList() {

		getLatestDataOfEmployee();

		return employees;
	}

	
//7	
	public String addEmployee(Employee employee) {

		System.out.println(employee);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Employee emp = null;

		String string = "Data rollBack..";

		try {

//			for (Country country : countries) {
//
//				employee.setCountry(country);
//				break;
//
//			}

			session.save(employee);
			tx.commit();
			string = "Employee Added Successfully..";

			/*
			 * getLatestDataOfEmployee();
			 * 
			 * for (Employee employ : employees) {
			 * 
			 * if (employ.getPhoneno().equals(employee.getPhoneno())) {
			 * 
			 * emp = employ; break; }
			 * 
			 * }
			 */

		} catch (Exception e) {

			System.out.println("exception handle in addEmployee..");

			e.printStackTrace();

			// return null;

		} finally {

			session.close();

		}
		// System.out.println("emp : " + emp);

		return string;
	}

	
//8	
	public String updateEmployee(Employee employee) {

		getLatestDataOfEmployee();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String string = "EmployeeId : " + employee.getId() + " is Not Present..";
		;

		Employee emp = null;

		for (Employee empl : employees) {

			if (empl.getId() == employee.getId()) {

				emp = empl;
				break;
			}
		}

		if (emp != null) {

			try {

				Employee empp = session.get(Employee.class, emp.getId());

				// session.delete(cou);
				// session.save(country);

				// if we execute above code then
				// id will change so thts y i dev below code

				empp.setName(employee.getName());
				empp.setPhoneno(employee.getPhoneno());
				empp.setDepartmentit(employee.getDepartmentit());
				empp.setStatus(employee.getStatus());
				empp.setUpdateddtm(employee.getUpdateddtm());
				empp.setCountry(employee.getCountry());

				session.update(empp);

				tx.commit();

				string = "EmployeeId : " + employee.getId() + " Updated Successfully..";

				/*
				 * getLatestDataOfEmployee();
				 * 
				 * for (Employee employ : employees) {
				 * 
				 * if (employ.getId().equals(employee.getId())) {
				 * 
				 * emp = employ;
				 * 
				 * break; } }
				 */

			} catch (Exception e) {

				System.out.println("exception handle in update..");

				e.printStackTrace();

				string = "Something Went Wrong..";

			} finally {

				session.close();
			}
		}

		// System.out.println(emp);

		return string;
	}

	
//9	
	public String deleteEmployeeById(Integer id) {

		getLatestDataOfEmployee();

		String string = "EmployeeId : " + id + " is Not Present..";

		Employee emp = null;

		for (Employee employee : employees) {

			if (employee.getId() == id) {

				emp = employee;

				break;
			}

		}

		if (emp != null) {

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				Employee empl = session.get(Employee.class, emp.getId());

				session.delete(empl);
				tx.commit();

				string = "EmployeeId : " + id + " Deleted Successfully..";

			} catch (Exception e) {

				System.out.println("exception handle in deleteEmployee..");
				e.printStackTrace();
				string = "Something Went Wrong..";

			} finally {

				session.close();
			}
		}

		return string;
	}

	
//10	
	public Employee getEmployeeById(Integer id) {

		getLatestDataOfEmployee();

		Employee emp = null;

		for (Employee employee : employees) {

			if (employee.getId() == id) {

				emp = employee;
				break;
			}

		}
		System.out.println(emp);
		return emp;
	}

}
