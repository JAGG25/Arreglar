package com.umg.programacion2.model;

import java.util.Date;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="compras")
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcompra")
	private Long id;
	@Column(name="no_orden_compra")
	private String no_orden_compra;
	@Column(name="fechaOrden")
	private Date fechaOrden;
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="idProveedore")
	private Proveedores proveedores;
	
	
	
	
	
	

	public Compras() {
		super();
	}

	public Compras(Long id, String no_orden_compra, Date fechaOrden, Date fechaIngreso, Proveedores proveedores) {
		super();
		this.id = id;
		this.no_orden_compra = no_orden_compra;
		this.fechaOrden = fechaOrden;
		this.fechaIngreso = fechaIngreso;
		this.proveedores = proveedores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNo_orden_compra() {
		return no_orden_compra;
	}

	public void setNo_orden_compra(String no_orden_compra) {
		this.no_orden_compra = no_orden_compra;
	}


	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrd) {
		this.fechaOrden = fechaOrd;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIng) {
		this.fechaIngreso = fechaIng;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedoesr(Proveedores proveedores) {
		this.proveedores = proveedores;
	}



	

	

	
	
	
	
}
