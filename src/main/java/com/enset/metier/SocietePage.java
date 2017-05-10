package com.enset.metier;

import java.io.Serializable;
import java.util.List;

import com.enset.entities.Societe;

public class SocietePage implements Serializable {
	
	private List< Societe> societes;
	private int nombre;
	private int nombreOfElements;
	private int size;
	private int totalPages;
	private Long totalSocietes;
	public SocietePage() {
		super();
	}
	public SocietePage(List<Societe> societes, int nombre, int nombreOfElements, int size, int totalPages,
			Long totalSocietes) {
		super();
		this.societes = societes;
		this.nombre = nombre;
		this.nombreOfElements = nombreOfElements;
		this.size = size;
		this.totalPages = totalPages;
		this.totalSocietes = totalSocietes;
	}
	public List<Societe> getSocietes() {
		return societes;
	}
	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getNombreOfElements() {
		return nombreOfElements;
	}
	public void setNombreOfElements(int nombreOfElements) {
		this.nombreOfElements = nombreOfElements;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalSocietes() {
		return totalSocietes;
	}
	public void setTotalSocietes(Long totalSocietes) {
		this.totalSocietes = totalSocietes;
	}
	

}
