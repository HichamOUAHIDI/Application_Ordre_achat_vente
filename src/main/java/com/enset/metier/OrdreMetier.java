package com.enset.metier;





import java.util.List;

import com.enset.entities.Achat;
import com.enset.entities.Ordre;
import com.enset.entities.Vente;


public interface OrdreMetier {
	public Ordre save(Ordre ordre);
	public boolean delete(Long id);
	public OrdrePage getOrdres(int page,int size);
	public Ordre getOrdre(Long id);
	public OrdrePage getOrdresSociete(String id,int page,int size);
	
	public List<Ordre> getOrdressocieteWithOutPage(String id);
	
	public List<Achat> getAchats(String id);
	public List<Vente> getVentes(String id);
	
	public Long getTotalActionsAchat(String id);
	public Long getTotalActionsVente(String id);
	
	public double getMoyenneAchat(String id);
	public double getMoyenneVente(String id);
	
	public double getActionPriceEstimate(String id);
	
	public void ajouterOrdersBySociete(String code);
	
	
}
