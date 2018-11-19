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
@Table(name="puestos")
public class Puestos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_puesto")
	private Long idPuesto;
	@Column(name="nombre")
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="puesto")
	@JsonManagedReference
	Set<Empleado> empleados = new HashSet<Empleado>();
	
	
	
	
	public Puestos() {
		super();
	}
	

	public Puestos(Long idPuesto, String nombre, Set<Empleado> empleados) {
		super();
		this.idPuesto = idPuesto;
		this.nombre = nombre;
		this.empleados = empleados;
	}




	public Long getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
	
	
	
	
	
}
