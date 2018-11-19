package com.umg.programacion2.model;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="marcas")
public class Marcas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_marcas")
	private Long idmarcas;
	@Column(name="Marcas")
	private String marcas;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="marcas")
	@JsonManagedReference
	Set<Productos> productos = new HashSet<Productos>();
	
	
	
	
	
	
	
	public Marcas() {
		super();
	}
	
	
	
	
	public Marcas(Long idmarcas, String marcas, Set<Productos> productos) {
		super();
		this.idmarcas = idmarcas;
		this.marcas = marcas;
		this.productos = productos;
	}




	public Long getIdmarcas() {
		return idmarcas;
	}
	public void setIdmarcas(Long idmarcas) {
		this.idmarcas = idmarcas;
	}
	public String getMarcas() {
		return marcas;
	}
	public void setMarcas(String Marcas) {
		this.marcas = Marcas;
	}
	public Set<Productos> getProductos() {
		return productos;
	}
	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}
	
	

	
	
	
	
	
	
	
}
