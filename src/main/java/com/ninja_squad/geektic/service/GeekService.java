package com.ninja_squad.geektic.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.DAO.GeekDAO;
import com.ninja_squad.geektic.Init.CentreInteret;
import com.ninja_squad.geektic.Init.Geek;

import javax.transaction.Transactional;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {

	@Autowired
	private GeekDAO gDAO;
	
	/*
    @RequestMapping(method = GET)
    public Geek afficherNom() {    	
        return gDAO.getGeeks().get(0);
    }  
    */
	
    @RequestMapping("/bysex/{sex}/{interet}")
    public List<Geek>afficherGeeksParSexe(@PathVariable("sex") String sex, @PathVariable("interet") String interet) {  
        return gDAO.getGeeksByCriteria(sex, interet);
    }  
    
    @RequestMapping("/interets")
    public List<CentreInteret> buildComboBox() {  
        return gDAO.getAllInterets();
    }  
    
}



