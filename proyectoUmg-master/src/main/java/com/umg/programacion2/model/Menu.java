package com.umg.programacion2.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="label")
	private String label;
	@Column(name="path")
	private String path;
	@Column(name="padre")
	private Long padre;
	@Column(name="favicon")
	private String favicon;
	@Column(name="prioridad")
	private Long prioridad;
	
	
	
	
	public Menu() {
		super();
	}
	
	
	public Menu(Long id, String label, String path, Long padre, String favicon, Long prioridad) {
		super();
		this.id = id;
		this.label = label;
		this.path = path;
		this.padre = padre;
		this.favicon = favicon;
		this.prioridad = prioridad;
	}









	public Long getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}
	public String getFavicon() {
		return favicon;
	}
	public void setFavicon(String favicon) {
		this.favicon = favicon;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getPadre() {
		return padre;
	}
	public void setPadre(Long padre) {
		this.padre = padre;
	}
	
	
	
}
