package com.umg.programacion2.model;

import java.util.Date;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEmpleado")
	private Long id;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private String telefono;
	@Column(name="dpi")
	private String dpi;
	@Column(name="genero")
	private boolean genero;
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name="fecha_inicio_labores")
	private Date fechaInicio;
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_puesto")
	private Puestos puesto;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="emppleado",cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonManagedReference
	Set<Ventas> ventas = new HashSet<Ventas>();
	
	
	
	
	
	
	
	
	public Empleado() {
		super();
	}
	public Empleado(Long id, String nombres, String apellidos, String direccion, String telefono, String dpi,
			boolean genero, Date fechaNacimiento, Date fechaInicio, Date fechaIngreso, Puestos puesto,
			Set<Ventas> ventas) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dpi = dpi;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInicio = fechaInicio;
		this.fechaIngreso = fechaIngreso;
		this.puesto = puesto;
		this.ventas = ventas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDpi() {
		return dpi;
	}
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Puestos getPuesto() {
		return puesto;
	}
	public void setPuesto(Puestos puesto) {
		this.puesto = puesto;
	}
	public Set<Ventas> getVentas() {
		return ventas;
	}
	public void setVentas(Set<Ventas> ventas) {
		this.ventas = ventas;
	}
	
	
	
	
	
	
	
	
}
