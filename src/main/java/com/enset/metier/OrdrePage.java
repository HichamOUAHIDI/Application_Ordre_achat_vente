package com.enset.metier;

import java.io.Serializable;
import java.util.List;

import com.enset.entities.Ordre;

public class OrdrePage implements Serializable {
	private List<Ordre> orders;
	private int nombre;
	private int nombreOfElements;
	private int size;
	private int totalPages;
	private Long totalSocietes;
	public OrdrePage() {
		super();
	}
	public OrdrePage(List<Ordre> orders, int nombre, int nombreOfElements, int size, int totalPages,
			Long totalSocietes) {
		super();
		this.orders = orders;
		this.nombre = nombre;
		this.nombreOfElements = nombreOfElements;
		this.size = size;
		this.totalPages = totalPages;
		this.totalSocietes = totalSocietes;
	}
	public List<Ordre> getOrders() {
		return orders;
	}
	public void setOrders(List<Ordre> orders) {
		this.orders = orders;
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
