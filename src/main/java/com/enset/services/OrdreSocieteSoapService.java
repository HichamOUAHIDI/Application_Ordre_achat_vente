package com.enset.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.enset.entities.Ordre;
import com.enset.entities.Societe;
import com.enset.metier.OrdreMetier;
import com.enset.metier.OrdrePage;
import com.enset.metier.SocieteMetier;
import com.enset.metier.SocietePage;

@Component
@WebService
public class OrdreSocieteSoapService {
	
	@Autowired
	private OrdreMetier ordreMetier;
	@Autowired
	private SocieteMetier societeMetier;
	@WebMethod
	public Ordre saveOrdre(Ordre ordre) {
		return ordreMetier.save(ordre);
	}
	@WebMethod
	public boolean deleteOrdre(@WebParam(name="code") Long id) {
		return ordreMetier.delete(id);
	}
	@WebMethod
	public OrdrePage getOrdres(@WebParam(name="page") int page,@WebParam(name="size") int size) {
		return ordreMetier.getOrdres(page, size);
	}
	@WebMethod
	public Ordre getOrdre(@WebParam(name="code") Long id) {
		return ordreMetier.getOrdre(id);
	}
	@WebMethod
	public OrdrePage getOrdresSociete(@WebParam(name="societeCode")String id,
			@WebParam(name="page") int page,
			@WebParam(name="size") int size) {
		return ordreMetier.getOrdresSociete(id, page, size);
	}
	
	@WebMethod
	public Societe saveSociete(Societe societe) {
		return societeMetier.save(societe);
	}
	@WebMethod
	public boolean deleteSociete(@WebParam(name="societeCode")String id) {
		return societeMetier.delete(id);
	}
	@WebMethod
	public SocietePage getSocietes(@WebParam(name="page") int page,@WebParam(name="size") int size) {
		return societeMetier.getSocietes(page, size);
	}
	@WebMethod
	public Societe getSociete(@WebParam(name="societeCode") String id) {
		return societeMetier.getSociete(id);
	}
	@WebMethod
	public Long totalActionsAchat(@WebParam String id) {
		return ordreMetier.getTotalActionsAchat(id);
	}
	@WebMethod
	public Long totalActionsVente(@WebParam String id) {
		return ordreMetier.getTotalActionsVente(id);
	}
	@WebMethod
	public double moyenneAchat(@WebParam String id) {
		return ordreMetier.getMoyenneAchat(id);
	}
	@WebMethod
	public double moyenneVente(@WebParam String id) {
		return ordreMetier.getMoyenneVente(id);
	}
	@WebMethod
	public double actionPriceEstimate(@WebParam String id) {
		return ordreMetier.getActionPriceEstimate(id);
	}

}
