package com.spring.test.akash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
public class Employee {

	@Id
	@Column(name = "Id")
	private String Eid;
	@Column(name = "name")
	private String eName;
	@Column(name="salary")
	private double salary;
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "DeptId")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Department department;
	
	public Employee() {
		
	}

	public Employee(String eid, String eName, double salary, Department department) {
		super();
		Eid = eid;
		this.eName = eName;
		this.salary = salary;
		this.department = department;
	}


	public String getEid() {
		return Eid;
	}

	public void setEid(String eid) {
		Eid = eid;
	}

	public String getEName() {
		return eName;
	}

	public void setEName(String eName) {
		this.eName = eName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", eName=" + eName + ", salary=" + salary + ", department=" + department + "]";
	}

	

}
