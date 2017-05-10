package com.enset.services;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.enset.entities.Ordre;
import com.enset.entities.Societe;
import com.enset.metier.OrdrePage;
import com.enset.metier.SocietePage;
@CrossOrigin("*")
@RestController
public class OdreSocieteService {
	@Autowired
	private com.enset.metier.OrdreMetier ordreMetier;
	@Autowired
	private com.enset.metier.SocieteMetier societeMetier;
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public Ordre getOrdre(@RequestParam Long id) {
		return ordreMetier.getOrdre(id);
	}
	@RequestMapping(value="/societe",method=RequestMethod.GET)
	public Societe getSociete(@RequestParam String id) {
		return societeMetier.getSociete(id);
	}
	@RequestMapping(value="/saveOrdre",method=RequestMethod.POST)
	public Ordre saveOrdre(@RequestBody Ordre ordre){
		 ordreMetier.save(ordre);
		 return ordre;
	}
	@RequestMapping(value="/saveSociete",method=RequestMethod.POST)
	public Societe saveSociete(@RequestBody Societe societe){
		societeMetier.save(societe);
		return societe;
	}
	@RequestMapping(value="/allOrdres",method=RequestMethod.GET)
	public OrdrePage listOrdres(@RequestParam int page,@RequestParam int size){
		return ordreMetier.getOrdres(page,size);
	}
	
	@RequestMapping(value="/allSocietes",method=RequestMethod.GET)
	public SocietePage listSociete(@RequestParam int page,@RequestParam int size){

		return societeMetier.getSocietes(page,size);
	}
	
	@RequestMapping(value="/listOrdresSociete",method=RequestMethod.GET)
	public OrdrePage listOrdresSociete(@RequestParam String id,@RequestParam int page,@RequestParam int size){
		return ordreMetier.getOrdresSociete(id, page, size);
	}
	@RequestMapping(value="/deleteOrdre",method=RequestMethod.GET)
	public Boolean deleteOdre(@RequestParam Long id){
		return ordreMetier.delete(id);
	}
	@RequestMapping(value="/deleteSociete",method=RequestMethod.GET)
	public Boolean deleteSociete(@RequestParam String id){
		return societeMetier.delete(id);
	}
	@RequestMapping(value="/totalActionsAchat",method=RequestMethod.GET)
	public Long getTotalActionsAchat(@RequestParam String id) {
		return ordreMetier.getTotalActionsAchat(id);
	}
	@RequestMapping(value="/totalActionsVente",method=RequestMethod.GET)
	public Long getTotalActionsVente(@RequestParam String id) {
		return ordreMetier.getTotalActionsVente(id);
	}
	@RequestMapping(value="/moyenneAchat",method=RequestMethod.GET)
	public double getMoyenneAchat(@RequestParam String id) {
		return ordreMetier.getMoyenneAchat(id);
	}
	@RequestMapping(value="/moyenneVente",method=RequestMethod.GET)
	public double getMoyenneVente(@RequestParam String id) {
		return ordreMetier.getMoyenneVente(id);
	}
	@RequestMapping(value="/actionPriceEstimate",method=RequestMethod.GET)
	public double getActionPriceEstimate(@RequestParam String id) {
		return ordreMetier.getActionPriceEstimate(id);
	}
}
