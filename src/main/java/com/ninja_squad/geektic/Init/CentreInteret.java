package com.ninja_squad.geektic.Init;

import javax.persistence.*;

@Entity
@Table(name="CENTRES_INTERET")
public class CentreInteret {
	
	@Id
	@Column(name="ID_INTERET")
	public int idInteret;
	
	@Column(name="INTERET")
	public String name;
}