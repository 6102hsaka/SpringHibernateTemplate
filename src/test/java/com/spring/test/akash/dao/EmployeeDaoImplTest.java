package com.spring.test.akash.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.spring.test.akash.model.Department;
import com.spring.test.akash.model.Employee;

public class EmployeeDaoImplTest {

	@Test
	public void testInsert_ENTER_NEW_DATA() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Department d = new Department("D001","Sales");
		Employee e = new Employee("E001","Akash",12000.00,d);
		boolean expected = eDao.insert(e);
		assertTrue(expected);
	}
	
	@Test
	public void testInsert_ENTER_DUPLICATE_DATA() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Department d = new Department("D001","Sales");
		Employee e = new Employee("E001","Akash",12000.00,d);
		boolean expected = eDao.insert(e);
		assertFalse(expected);
	}
	
	@Test
	public void testUpdate_WHEN_DATA_IS_PRESENT() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Department d = new Department("D001","Sales");
		Employee e = new Employee("E001","Akash Sharma",10000.00,d);
		boolean expected = eDao.update(e);
		assertTrue(expected);
	}
	
	@Test
	public void testUpdate_WHEN_DATA_IS_NOT_PRESENT() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Department d = new Department("D001","Sales");
		Employee e = new Employee("E010","Aaditya",12000.00,d);
		boolean expected = eDao.update(e);
		assertFalse(expected);
	}
	
	@Test
	public void testDelete() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Department d = new Department("D001","Sales");
		Employee e = new Employee("E001","Aaditya",10000.00,d);
		boolean expected = eDao.delete(e);
		assertTrue(expected);
	}
	
	/*
	@Test
	public void testDelete_WHEN_DATA_IS_NOT_PRESENT() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		Employee e = new Employee("E005","Aaditya",10000.00);
		boolean expected = eDao.delete(e);
		assertFalse(expected);
	}
	*/
	
	@Test
	public void testGetById_WHEN_DATA_IS_PRESENT() {
		Employee employee = new EmployeeDaoImpl().getById("E001");
		assertNotNull(employee);
	}
	
	@Test
	public void testGetById_WHEN_DATA_IS_NOT_PRESENT() {
		Employee employee = new EmployeeDaoImpl().getById("E005");
		assertNull(employee);
	}
	
	@Test
	public void testGetAllEmp_WHEN_DATA_IS_PRESENT() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		List<Employee> employees= eDao.getAllEmp();
		employees.forEach(System.out::println);
		int actual_size = employees.size();
		int expected_size = 0;
		assertNotNull(employees);
		assertNotEquals(expected_size, actual_size);
	}
	
	@Test
	public void testGetAllEmp_WHEN_DATA_IS_NOT_PRESENT() {
		EmployeeDao eDao = new EmployeeDaoImpl();
		List<Employee> employees= eDao.getAllEmp();
		int actual_size = employees.size();
		int expected_size = 0;
		assertNotNull(employees);
		assertEquals(expected_size, actual_size);
	}
	
}
