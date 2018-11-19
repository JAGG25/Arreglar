package com.umg.programacion2.model;

import java.util.Date;



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
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idCliente")
	private Long idCliente;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="nit")
	private String nit;
	@Column(name="genero")
	private boolean genero;
	@Column(name="telefono")
	private String telefono;
	@Column(name="correo_electronico")
	private String correoElectronico;
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="cliente")
	@JsonManagedReference
	Set<Ventas> ventas = new HashSet<Ventas>();
	
	
	
	
	public Cliente(Long idCliente, String nombres, String apellidos, String nit, boolean genero, String telefono,
			String correoElectronico, Date fechaIngreso, Set<Ventas> ventas) {
		super();
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nit = nit;
		this.genero = genero;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.fechaIngreso = fechaIngreso;
		this.ventas = ventas;
	}
	
	
	public Cliente() {
		super();
	}


	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String id) {
		this.nit = id;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorroeElectronico() {
		return correoElectronico;
	}
	public void setCorroeElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Set<Ventas> getVentas() {
		return ventas;
	}
	public void setVentas(Set<Ventas> ventas) {
		this.ventas = ventas;
	}
	
	
	
	
}
