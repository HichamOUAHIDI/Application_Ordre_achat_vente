package com.enset.metier;


import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.enset.dao.OrdreRepository;
import com.enset.dao.SocieteRepository;
import com.enset.entities.Achat;
import com.enset.entities.Ordre;
import com.enset.entities.Societe;
import com.enset.entities.Vente;

@Service
public class OrderMetierImpl implements OrdreMetier{
	@Autowired
	private OrdreRepository ordreRepository;
	@Autowired
	private SocieteRepository societeRepository;

	@Override
	public Ordre save(Ordre ordre) {
		
		
		ordreRepository.save(ordre);
		return ordre;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		ordreRepository.delete(id);
		return true;
	}

	

	@Override
	public Ordre getOrdre(Long id) {
		return ordreRepository.findOne(id);
	}

	

	@Override
	public OrdrePage getOrdres(int page,int size) {
		
		Page<Ordre> ordres=ordreRepository.findAll(new PageRequest(page, size));
		return new OrdrePage(ordres.getContent(),ordres.getNumber(),ordres.getNumberOfElements(), ordres.getSize(), ordres.getTotalPages(), ordres.getTotalElements());
	}

	@Override
	public OrdrePage getOrdresSociete(String id,int page,int size) {
		Page<Ordre> ordres=ordreRepository.getOrdresSociete(id, new PageRequest(page, size));
		return new OrdrePage(ordres.getContent(),ordres.getNumber(),ordres.getNumberOfElements(), ordres.getSize(), ordres.getTotalPages(), ordres.getTotalElements());
	}

	@Override
	public Long getTotalActionsAchat(String id) {
		// TODO Auto-generated method stub
		Long num=new Long(0);
		List<Achat> ordres=ordreRepository.getAchats(id);
		Iterator<Achat> it=ordres.iterator();
		while(it.hasNext()){
			num+=it.next().getNombre_actions();
		}
		return num;
	}

	@Override
	public Long getTotalActionsVente(String id) {
		Long num=new Long(0);
		List<Vente> ordres=ordreRepository.getVentes(id);
		Iterator<Vente> it=ordres.iterator();
		while(it.hasNext()){
			num+=it.next().getNombre_actions();
		}
		return num;
	}

	@Override
	public double getMoyenneAchat(String id) {
		// TODO Auto-generated method stub
		
		Double num=new Double(0);
		List<Achat> ordres=ordreRepository.getAchats(id);
		if(ordres.isEmpty())
				return 0;
		Iterator<Achat> it=ordres.iterator();
		while(it.hasNext()){
			num+=it.next().getPrix();
		}
		return num/ordres.size();
	}

	@Override
	public double getMoyenneVente(String id) {
		Double num=new Double(0);
		List<Vente> ordres=ordreRepository.getVentes(id);
		if(ordres.isEmpty())
				return 0;
		Iterator<Vente> it=ordres.iterator();
		while(it.hasNext()){
			num+=it.next().getPrix();
		}
		return num/ordres.size();
	}

	@Override
	public double getActionPriceEstimate(String id) {
		// TODO Auto-generated method stub
		return (getMoyenneAchat(id)+getMoyenneVente(id))/2;
	}

	@Override
	public List<Ordre> getOrdressocieteWithOutPage(String id) {
		// TODO Auto-generated method stub
		return ordreRepository.getOrdresSocieteWithOutPage(id);
	}

	@Override
	public List<Achat> getAchats(String id) {
		// TODO Auto-generated method stub
		return ordreRepository.getAchats(id);
	}

	@Override
	public List<Vente> getVentes(String id) {
		// TODO Auto-generated method stub
		return ordreRepository.getVentes(id);
	}
	
	  @Override
	    public void ajouterOrdersBySociete(String code) {
		  
	        Document doc;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm");
	        try {
	            doc = Jsoup.connect("https://www.wafabourse.com/trader/market/"+code+"/XCAS/ISIN").get();
	            Elements stes = doc.select("table.tab_ordres");
	            Date date = simpleDateFormat.parse(doc.select("#instrLAST_PRICE_DATE").text());
	         
	            String str= stes.text();
	            NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);

	            for (org.jsoup.nodes.Element ste : stes) {
	                str=ste.select("th.th_achat").text();
	                if(str.equals("Achat")){
	                    Elements li=ste.select("tr");
	                    for(int i=3;i<li.size();i++){

	                        if(li.get(i).select("td.bidVolume").text().trim().isEmpty()==false ){
	                            if(li.get(i).select("td.bidVolume").text().trim().charAt(0)!='-')
	                            {
	                              //  System.out.printf("[ QTE :"+nf.parse(li.get(i).select("td.bidVolume").text()).shortValue() +" | ");
	                             //   System.out.println(nf.parse(li.get(i).select("td.bidPrice").text()).doubleValue()+" DH]");
	                                Societe societe=societeRepository.findOne(code.trim());
	                                Achat achat=new Achat(nf.parse(li.get(i).select("td.bidVolume").text()).shortValue(), nf.parse(li.get(i).select("td.bidPrice").text()).doubleValue(), date);
	                                achat.setSociete(societe);
	                                save(achat);
	                            }}
	                    }
	                }
	                else if(ste.select("th.th_vente").text().equals("Vente")){
	                    Elements li=ste.select("tr");
	                    for(int i=3;i<li.size();i++){
	                        if(li.get(i).select("td.askPrice").text().isEmpty()==false ){
	                            if( li.get(i).select("td.askPrice").text().charAt(0)!='-')
	                            {
	                            //    System.out.printf("[QTE :"+nf.parse(li.get(i).select("td.askVolume").text()).shortValue() +" | ");
	                            //    System.out.println(nf.parse(li.get(i).select("td.askPrice").text()).doubleValue()+" DH]");
	                                Societe societe=societeRepository.findOne(code.trim());
	                                Vente vente=new Vente(nf.parse(li.get(i).select("td.askVolume").text()).shortValue(), nf.parse(li.get(i).select("td.askPrice").text()).doubleValue(), date);
	                                vente.setSociete(societe);
	                                save(vente);
	                            }}
	                    }
	                }

	            }
	        } catch (IOException | ParseException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }


	    }
	
	

	

}
