package com.enset.entities;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_Ordre",discriminatorType=DiscriminatorType.STRING,length=5)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="ACHAT",value=Achat.class),
	@Type(name="VENTE",value=Vente.class)
})
@XmlSeeAlso({Achat.class,Vente.class})

public abstract class Ordre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private int nombre_actions;
	private Double prix;
	private Date date;
	@ManyToOne()
	@JoinColumn(name="idSociete")
	private Societe societe;
	
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Ordre(int nombre_actions, Double prix, Date date) {
		super();
		this.nombre_actions = nombre_actions;
		this.prix = prix;
		this.date = date;
	}


	public Long getNumero() {
		return numero;
	}
	
	public int getNombre_actions() {
		return nombre_actions;
	}
	public void setNombre_actions(int nombre_actions) {
		this.nombre_actions = nombre_actions;
	}
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	

}

