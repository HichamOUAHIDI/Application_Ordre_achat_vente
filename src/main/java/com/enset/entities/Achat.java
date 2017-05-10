package com.enset.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@DiscriminatorValue("ACHAT")
@OnDelete(action = OnDeleteAction.CASCADE)
@XmlType(name="ACHAT")
@XmlRootElement(name = "ACHAT")
public class Achat extends Ordre {

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(int nombre_actions, Double prix, Date date) {
		super(nombre_actions, prix, date);
		// TODO Auto-generated constructor stub
	}


}
