package com.spring.test.akash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@Column(name = "Id")
	private String deptId;
	@Column(name = "name")
	private String dName;
	
	public Department() {
		
	}

	public Department(String deptId, String dName) {
		super();
		this.deptId = deptId;
		this.dName = dName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", dName=" + dName + "]";
	}
}
