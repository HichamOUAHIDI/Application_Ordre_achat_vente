package com.enset.rmi;

import java.rmi.Remote;


import java.rmi.RemoteException;
import java.util.List;

import com.enset.entities.Achat;
import com.enset.entities.Ordre;
import com.enset.entities.Societe;
import com.enset.entities.Vente;
import com.enset.metier.OrdrePage;
import com.enset.metier.SocietePage;

public interface SocieteOrdreRmiService extends Remote {
	
	public Societe saveSociete(Societe societe) throws RemoteException;
	public Societe getSociete(String code) throws RemoteException;
	
	public Ordre saveOrdre(Ordre societe) throws RemoteException;
	public Ordre getOrdre(Long code) throws RemoteException;
	
	public List<Achat> getAchats(String code) throws RemoteException;
	public List<Vente> getVente(String code) throws RemoteException;
	
	public SocietePage getallSocietes(int page,int size) throws RemoteException;
	public List<Ordre> getOrdresSociete(String id) throws RemoteException;
	
	public boolean deleteOrdre(Long id) throws RemoteException;
	public boolean deleteSociete(String id) throws RemoteException;
	
	public Long getTotalActionsVente(String id) throws RemoteException;
	public Long getTotalActionsAchat(String id) throws RemoteException;
	
	public double getMoyenneAchat(String id) throws RemoteException;
	public double getMoyenneVente(String id) throws RemoteException;
	
	public double getActionPriceEstimate(String id) throws RemoteException;
	
	

}
