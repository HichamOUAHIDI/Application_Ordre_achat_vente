package com.enset.metier;




import com.enset.entities.Societe;
public interface SocieteMetier {
	public Societe save(Societe societe);
	public boolean delete(String id);
	public SocietePage getSocietes(int page,int size);
	public Societe getSociete(String id);
	
	public void SaveSocietesJsoup();
	public boolean societeExiste(String id) ;
	public void SocieteWithOrderWafaBANK();
	
	
	
}
