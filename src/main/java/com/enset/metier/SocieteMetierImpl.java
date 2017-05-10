package com.enset.metier;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.enset.dao.SocieteRepository;
import com.enset.entities.Societe;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class SocieteMetierImpl implements SocieteMetier{
	@Autowired
	public SocieteRepository societeRepository;
	@Autowired
	public OrdreMetier ordreMetier;
	@Override
	public Societe save(Societe societe) {
		societeRepository.save(societe);
		return societe;
	}

	@Override
	public boolean delete(String id) {
		societeRepository.delete(id);
		return true;
	}

	@Override
	public SocietePage getSocietes(int page,int size) {
		SocietePage societePage=new SocietePage();
		Page<Societe> societes=societeRepository.findAll(new PageRequest(page, size));
		societePage.setSocietes(societes.getContent());
		societePage.setSize(societes.getSize());
		societePage.setNombre(societes.getNumber());
		societePage.setTotalPages(societes.getTotalPages());
		societePage.setTotalSocietes(societes.getTotalElements());
		societePage.setNombreOfElements(societes.getNumberOfElements());
		return societePage;
	}

	@Override
    public boolean societeExiste(String id) {
        if(id!=null){
            if(societeRepository.findOne(id) !=null){
                return true;
            }
        }
        return false;
    }
	@Override
	public Societe getSociete(String id) {
		return societeRepository.findOne(id);
	}
		@Override
	   public void SaveSocietesJsoup() {
	        Document doc;
	        try {
	            doc = Jsoup.connect("https://www.wafabourse.com/marches/actions/r").get();
	            Elements societes = doc.select("td.longNameQS a");
	            String id;
	      //      System.out.println("=========================================================");
	            for (Element societe : societes) {
	                id=societe.attr("href").split("/")[3];

	                if( !societeExiste(id.trim())){
	                    save(new Societe(societe.attr("href").split("/")[3], societe.text()));
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Scheduled(fixedRate = 500000)
	    public void SocieteWithOrderWafaBANK(){
	        SaveSocietesJsoup();
	        List<Societe> s=societeRepository.findAll();
	        for (Societe societe : s) {
	            ordreMetier.ajouterOrdersBySociete(societe.getCode().trim());
	        }

	    }

}
