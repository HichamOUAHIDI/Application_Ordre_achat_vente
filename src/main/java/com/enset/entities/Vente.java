package com.enset.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@DiscriminatorValue("VENTE")
@OnDelete(action = OnDeleteAction.CASCADE)
@XmlType(name="VENTE")
@XmlRootElement(name = "VENTE")
public class Vente extends Ordre{
	
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(int nombre_actions, Double prix, Date date) {
		super(nombre_actions, prix, date);
		// TODO Auto-generated constructor stub
	}

	
	

}