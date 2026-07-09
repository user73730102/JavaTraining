package com.mmcoe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mmcoe.entity.Customer;

public class CustomerDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}

	public Customer save(Customer c) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(c);
			txn.commit();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return null;
		} finally {
			mgr.close();
		}
	}
	
	public Customer find(int custId) {
		EntityManager mgr = emf.createEntityManager();
		try {
			return mgr.find(Customer.class, custId);
		}finally {
			mgr.close();
		}
	}
	
	public List<Customer> list() {
		EntityManager mgr = emf.createEntityManager();
		try {
			Query query = mgr.createQuery("FROM Customer");
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}
	
	public boolean delete(int custId) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Customer c = mgr.find(Customer.class, custId);
			mgr.remove(c);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			mgr.close();
		}
	}
}

