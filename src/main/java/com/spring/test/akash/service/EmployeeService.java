package com.spring.test.akash.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.test.akash.config.AppConfig;
import com.spring.test.akash.dao.EmployeeDao;
import com.spring.test.akash.dao.EmployeeDaoImpl;
import com.spring.test.akash.model.Department;
import com.spring.test.akash.model.Employee;

public class EmployeeService {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDao eDao = context.getBean("getEmpDao",EmployeeDaoImpl.class);

		Department hr = new Department("D001", "Human Resource");
		Department it = new Department("D002", "IT");
		Department finance = new Department("D003", "Finance");

		Employee e1 = new Employee("E001", "Akash", 12000.00, it);
		Employee e2 = new Employee("E002", "Aman", 12000.00, finance);
		Employee e3 = new Employee("E003", "Anuj", 15000.00, hr);
		Employee e4 = new Employee("E004", "Aniket", 12000.00, it);
		Employee e5 = new Employee("E005", "Agnimitra", 15000.00, hr);
		Employee e6 = new Employee("E006", "Sarish", 12000.00, it);
		Employee e7 = new Employee("E007", "Pravash", 15000.00, finance);

		Employee[] employees = { e1, e2, e3, e4, e5, e6, e7 };

		// saving employees details
		for (Employee emp : employees) {
			if (eDao.insert(emp)) {
				System.out.println(emp.getEName() + "'s details saved successfully");
			} else {
				System.out.println("Error in saving " + emp.getEName() + "'s details");
			}
		}

		// updating employee record 
		e7.setSalary(17000.00); 
		e7.setDepartment(it);
		if(eDao.update(e7)) {
			System.out.println(e7.getEName()+"'s details updated successfully");
		} else {
			System.out.println(e7.getEName()+"'s details not updated");
		}

		// get Employee detail by id
		Employee emp = eDao.getById("E001");
		System.out.println(emp);

		// deleting record using id
		if (eDao.delete(e3)) {
			System.out.println(e3.getEName() + "'s record deleted successfully");
		} else {
			System.out.println(e3.getEName() + "'s record cannot be deleted");
		}

		// get Details of all employees 
		List<Employee> list = eDao.getAllEmp();
		list.forEach(System.out::println);
	}
}
