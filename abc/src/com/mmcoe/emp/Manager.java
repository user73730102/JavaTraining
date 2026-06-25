package com.mmcoe.emp;

public class Manager extends Employee{
	private double comission;
	public Manager(double salary, double comission) {
		super(salary);
		this.comission=comission;
	}
	@Override
	public double getSalary()
	{
		return super.getSalary()+comission;
	}
	
}
