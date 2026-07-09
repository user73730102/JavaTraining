package com.mmcoe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mmcoe.entity.Department;
import com.mmcoe.entity.Employee;

public class EmpDeptDao {

	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public Department saveDept(Department d) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(d);
		txn.commit();
		return d;
	}
	
	public Employee saveEmp(Employee e, int deptNo) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Department d = mgr.find(Department.class, deptNo);
		e.setDept(d);
		mgr.persist(e);
		txn.commit();
		return e;
	}
	
	public Employee findEmp(int empId) {
		EntityManager mgr = emf.createEntityManager();
		
		return mgr.find(Employee.class, empId);
	}
	
	public Department findDept(int deptNo) {
		EntityManager mgr = emf.createEntityManager();
		
		return mgr.find(Department.class, deptNo);
	}
	
	public boolean deleteDept(int deptNo) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Department d = mgr.find(Department.class, deptNo);
		mgr.remove(d);
		txn.commit();
		return true;
	}
}

