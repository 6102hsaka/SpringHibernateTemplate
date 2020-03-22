package com.spring.test.akash.dao;

import java.util.List;

import com.spring.test.akash.model.Employee;

public interface EmployeeDao {
	
	public boolean insert(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(Employee employee);
	
	public Employee getById(String id);
	public List<Employee> getAllEmp();

}
