package com.ninja_squad.geektic.DAO;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.Init.CentreInteret;
import com.ninja_squad.geektic.Init.Geek;

@Repository
public class GeekDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Geek> getGeeks()
	{
        TypedQuery<Geek> query = em.createQuery("SELECT g from Geek as g", Geek.class);
        return query.getResultList();
    }
	
	
	public List<Geek> getGeeksByCriteria(String s, String i)
	{	
		if (i.equals("Tous")){
			TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g LEFT JOIN FETCH g.centresInteret INNER JOIN g.centresInteret as i where g.sexe=:sexe", Geek.class);
	        query.setParameter("sexe", s);
	        return query.getResultList();
			
		}else{
			TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g LEFT JOIN FETCH g.centresInteret INNER JOIN g.centresInteret as i where g.sexe=:sexe and i.name=:interet", Geek.class);
	        query.setParameter("sexe", s).setParameter("interet", i);
	        return query.getResultList();
		}
		
	}
	
	public List<CentreInteret> getAllInterets()
	{
		TypedQuery<CentreInteret> query = em.createQuery("SELECT c from CentreInteret as c", CentreInteret.class);
		return query.getResultList();
	}
}