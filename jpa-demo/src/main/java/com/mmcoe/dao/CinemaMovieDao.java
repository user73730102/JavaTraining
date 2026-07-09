package com.mmcoe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mmcoe.entity.Cinema;
import com.mmcoe.entity.Movie;

public class CinemaMovieDao {
	private EntityManagerFactory emf;
	
	public CinemaMovieDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public Object save(Object obj) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(obj);
		txn.commit();
		return obj;
	}
	
	public boolean addMovieToCinema(int mid, int cid) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Movie m = mgr.find(Movie.class, mid);
		Cinema c = mgr.find(Cinema.class, cid);
		
		c.getMovies().add(m);
		txn.commit();
		return true;
	}
	
	public List<Cinema> findByMovieTitle(String title) {
		String hql = "SELECT c FROM Cinema c JOIN c.movies m WHERE m.title=:title";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("title", title);
		return query.getResultList();
	}
	
	public List<Movie> findByGenre(String genre) {
		String hql = "FROM Movie WHERE genre=:genre";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("genre", genre);
		return query.getResultList();
	}
	
	public List<Cinema> findByLocation(String city) {
		String hql = "FROM Cinema WHERE location=:city";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("city", city);
		return query.getResultList();
	}
	
	public List<Movie> findMovieByLocation(String city) {
		String hql = "SELECT m FROM Movie m JOIN m.cinemas c WHERE c.location=:city";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("city", city);
		return query.getResultList();
	}
}

