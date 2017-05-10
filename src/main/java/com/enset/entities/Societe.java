package com.enset.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Societe implements Serializable{
	
	@Id
	private String code;
	private String nom;
	
	@OneToMany(mappedBy="societe",fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Ordre> ordres;
	
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societe(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Ordre> getOrdres() {
		return ordres;
	}
	@JsonSetter
	public void setOrdres(Collection<Ordre> ordres) {
		this.ordres = ordres;
	}
	
	

}

