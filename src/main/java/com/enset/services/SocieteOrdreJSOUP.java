package com.enset.services;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enset.metier.SocieteMetier;


public class SocieteOrdreJSOUP {
	
	@Autowired
	private SocieteMetier societeMetier;
	public void SocieteOrdreWithJSOUP(){
		societeMetier.SocieteWithOrderWafaBANK();
	}
}
