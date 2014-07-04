package com.ninja_squad.geektic.dao;

import java.util.*;

import com.ninja_squad.geektic.DAO.GeekDAO;
import com.ninja_squad.geektic.Init.CentreInteret;
import com.ninja_squad.geektic.Init.Geek;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;


public class GeekDAOTest extends BaseDaoTest {
	
	@Autowired
	private GeekDAO gDao;
   

	@Test
    public void testGenreGetGeekByCriteria() {
       List<Geek> result = gDao.getGeeksByCriteria("M", "PHP");
       Assert.assertEquals(2, result.get(0).idGeek);
       Assert.assertEquals(2,result.size());
    }
	
	@Test
    public void testInteretGetGeekByCriteria() {
		int test = 2; 
       List<Geek> result = gDao.getGeeksByCriteria("M", "PHP");
       Assert.assertEquals(test , result.size());
    }
	
	@Test
    public void testAllInterests() {
		int test = 4; 
	       List<CentreInteret> result = gDao.getAllInterets();
	       Assert.assertEquals(test , result.size());
		
	}
	@Test
    public void testGetGeekByCriteriaTous() {
		
		List<Geek> result = gDao.getGeeksByCriteria("M", "Tous");
	       Assert.assertEquals( 3, result.size());
		
	}
	
	
	
	
}