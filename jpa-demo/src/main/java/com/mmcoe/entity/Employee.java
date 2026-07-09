package com.mmcoe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "emp")
public class Employee {
	@Id @Column(name = "emp_id")
	private int empId;
	@Column(name = "ename")
	private String empName;
	private String job;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "dept_no")
	private Department dept;
	
	public Employee() {
	}
	public Employee(int empId, String empName, String job, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.job = job;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", job=" + job + ", salary=" + salary + "]";
	}
	
	// Getters & Setters for all fields
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
