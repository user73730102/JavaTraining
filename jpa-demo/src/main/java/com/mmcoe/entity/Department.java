package com.mmcoe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "dept")
public class Department {
	@Id @Column(name = "dept_no")
	private int deptNo;
	@Column(name = "dname")
	private String deptName;
	private String location;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> emps = new ArrayList<Employee>();
	
	public Department() {
	}
	public Department(int deptNo, String deptName, String location) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
	// Getters & Setters for all fields
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}
