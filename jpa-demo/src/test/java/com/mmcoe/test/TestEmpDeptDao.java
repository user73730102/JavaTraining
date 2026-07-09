package com.mmcoe.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mmcoe.dao.EmpDeptDao;
import com.mmcoe.entity.Department;
import com.mmcoe.entity.Employee;

public class TestEmpDeptDao {

	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new EmpDeptDao();
	}
	
	@Test
	public void testSaveDept() {
		Department dept = new Department(50, "LND", "Hyderabad");
		assertNotNull(dao.saveDept(dept));
	}
	
	@Test
	public void testSaveDeptWithEmps() {
		Department dept = new Department(60, "Marketing", "Kolkata");
		
		Employee e1 = new Employee(601, "Nik", "Manager", 8800);
		Employee e2 = new Employee(602, "Ben", "Clerk", 6200);
		
		e1.setDept(dept);
		e2.setDept(dept);
		
		dept.getEmps().add(e1);
		dept.getEmps().add(e2);
		
		assertNotNull(dao.saveDept(dept));
	}
	
	@Test
	public void testSaveEmp() {
		Employee emp = new Employee(901, "Rocky", "Peon", 600);
		assertNotNull(dao.saveEmp(emp, 0));
	}
	
	@Test
	public void testFindEmp() {
		Employee emp = dao.findEmp(502);
		assertNotNull(emp);
		System.out.println(emp);
		
		Department dept = emp.getDept();
		System.out.println(dept);
	}
	
	@Test
	public void testFindDept() {
		Department dept = dao.findDept(50);
		assertNotNull(dept);
		System.out.println(dept);
		
		List<Employee> emps = dept.getEmps();
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testDeleteDept() {
		assertTrue(dao.deleteDept(60));
	}
}

