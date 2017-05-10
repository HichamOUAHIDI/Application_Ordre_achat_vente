package com.enset.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enset.entities.Achat;
import com.enset.entities.Ordre;
import com.enset.entities.Societe;
import com.enset.entities.Vente;
import com.enset.metier.OrdreMetier;
import com.enset.metier.OrdrePage;
import com.enset.metier.SocieteMetier;
import com.enset.metier.SocietePage;

@Component("OrdreSocieteRmiService")
public class SocieteOrdreRmiImpl implements SocieteOrdreRmiService {
	
	@Autowired
	private OrdreMetier ordreMetier;
	@Autowired
	private SocieteMetier societeMetier;
	@Override
	public Societe saveSociete(Societe societe) throws RemoteException {
		// TODO Auto-generated method stub
		return societeMetier.save(societe);
	}
	@Override
	public Societe getSociete(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return societeMetier.getSociete(code);
	}
	@Override
	public Ordre saveOrdre(Ordre societe) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.save(societe);
	}
	@Override
	public Ordre getOrdre(Long code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getOrdre(code);
	}
	@Override
	public SocietePage getallSocietes(int page, int size) throws RemoteException {
		// TODO Auto-generated method stub
		return societeMetier.getSocietes(page, size);
	}

	@Override
	public boolean deleteOrdre(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.delete(id);
	}
	@Override
	public boolean deleteSociete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return societeMetier.delete(id);
	}
	@Override
	public Long getTotalActionsVente(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getTotalActionsAchat(id);
	}
	@Override
	public Long getTotalActionsAchat(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getTotalActionsAchat(id);
	}
	@Override
	public double getMoyenneAchat(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getMoyenneAchat(id);
	}
	@Override
	public double getMoyenneVente(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getMoyenneVente(id);
	}
	@Override
	public double getActionPriceEstimate(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getActionPriceEstimate(id);
	}
	@Override
	public List<Ordre> getOrdresSociete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getOrdressocieteWithOutPage(id);
	}
	@Override
	public List<Achat> getAchats(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getAchats(code);
	}
	@Override
	public List<Vente> getVente(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordreMetier.getVentes(code);
	}
	
	

	
}
