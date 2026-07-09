package com.mmcoe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mmcoe.entity.Book;

public class BookDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public Book save(Book b) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(b);
		txn.commit();
		return b;
	}
	
	public Book find(int isbn) {
		EntityManager mgr = emf.createEntityManager();
		return mgr.find(Book.class, isbn);
	}
	
	public List<Book> list() {
		EntityManager mgr = emf.createEntityManager();
		return mgr.createQuery("FROM Book").getResultList();
	}
}
