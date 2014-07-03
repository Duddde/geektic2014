package com.ninja_squad.geektic.Init;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="GEEK")
public class Geek {
	
	@Id
	@Column(name="ID")
	public int idGeek;
	
	@Column(name="NOM")
	public String nom;
	
	@Column(name="PRENOM") 
	public String prenom;
	
	@Column(name="AGE")
	public String age;
	
	@Column(name="SEXE")
	public String sexe;
	
	@Column(name="MAIL")
	public String mail;
	
	@Column(name="CHEMAVATAR")
	public String cheminAvatar;
	
	@ManyToMany
	@JoinTable(
	      name="GEEK_CENTRES_INTERET",
	      joinColumns={@JoinColumn(name="ID_GEEK", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="ID_INTERET", referencedColumnName="ID_INTERET")})
    public Set<CentreInteret> centresInteret;
}
