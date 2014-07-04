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
        TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g LEFT JOIN FETCH g.centresInteret", Geek.class);
        return query.getResultList();
    }
	
	
	public List<Geek> getGeeksByCriteria(String sex, String interet)
	{	
		
		
		if (interet.equals("Tous")){
			TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g LEFT JOIN FETCH g.centresInteret  where g.sexe=:sexe", Geek.class);
	        query.setParameter("sexe", sex);
	        return query.getResultList();
			
		}else{
			TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g LEFT JOIN FETCH g.centresInteret INNER JOIN g.centresInteret as i where g.sexe=:sexe and i.name=:interet", Geek.class);
	        query.setParameter("sexe", sex).setParameter("interet", interet);
	        return query.getResultList();
		}
		
	}
	
	public List<CentreInteret> getAllInterets()
	{
		TypedQuery<CentreInteret> query = em.createQuery("SELECT c from CentreInteret as c", CentreInteret.class);
		return query.getResultList();
	}
}