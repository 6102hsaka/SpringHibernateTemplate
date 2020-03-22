package com.spring.test.akash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.akash.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hTemp;	
	
	@Override
	@Transactional
	public boolean insert(Employee employee) {
		try {
			hTemp.save(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean update(Employee employee) {
		try {
			hTemp.update(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean delete(Employee employee) {
		try {
			hTemp.delete(employee);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public Employee getById(String id) {
		Employee employee = null;
		employee = hTemp.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmp() {
		List<Employee> employees = null;
		employees = hTemp.loadAll(Employee.class);
		return employees;
	}
}
