package com.enset.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enset.entities.Achat;
import com.enset.entities.Ordre;
import com.enset.entities.Vente;

public interface OrdreRepository extends JpaRepository<Ordre, Long> {
	
	@Query("select o from Ordre o where o.societe.id= :x")
	public Page<Ordre> getOrdresSociete(@Param("x") String id,Pageable pageable);
	
	@Query("select o from Ordre o where o.societe.id= :x")
	public List<Ordre> getOrdresSocieteWithOutPage(@Param("x") String id);
	
	@Query("select o from Achat o where o.societe.id= :x ")
	public List<Achat> getAchats(@Param("x") String id);
	
	@Query("select o from Vente o where o.societe.id= :x ")
	public List<Vente> getVentes(@Param("x") String id);
	
	@Query("select o from Ordre o where o.societe.id= :x")
	public List<Ordre> getAllOrdres(@Param("x") String id);
}
