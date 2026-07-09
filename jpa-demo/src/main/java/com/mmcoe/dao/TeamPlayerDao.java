package com.mmcoe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mmcoe.entity.Player;
import com.mmcoe.entity.Team;

public class TeamPlayerDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public Team saveTeam(Team t) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(t);
		txn.commit();
		return t;
	}
	
	public Player savePlayer(Player p, String code) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Team t = mgr.find(Team.class, code);
		p.setTeam(t);
		mgr.persist(p);
		txn.commit();
		return p;
	}
	
	public List<Player> findByRole(String role) {
		String hql = "FROM Player WHERE role=:role";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("role", role);
		return query.getResultList();
	}
	
	public List<Player> findByBidAmountRange(double min, double max) {
		String hql = "FROM Player WHERE bidAmount BETWEEN :min AND :max";
		
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery(hql);
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList();
	}
	
}

