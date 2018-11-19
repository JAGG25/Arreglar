package com.umg.programacion2.model;

import java.util.HashSet;
import java.util.Set;

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
@Table(name="proveedores")
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idProveedore")
	private Long idProveedore;
	@Column(name="proveedor")
	private String proveedor;
	@Column(name="nit")
	private String nit;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private String telefono;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="idProducto")
	private Productos productos;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="proveedores")
	@JsonManagedReference
	Set<Compras> compras = new HashSet<Compras>();
	
	
	
	public Proveedores() {
		super();
	}
	
	
	public Proveedores(Long idProveedore, String proveedor, String nit, String direccion, String telefono,
			Productos productos, Set<Compras> compras) {
		super();
		this.idProveedore = idProveedore;
		this.proveedor = proveedor;
		this.nit = nit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.productos = productos;
		this.compras = compras;
	}





	public Long getIdProveedore() {
		return idProveedore;
	}
	public void setIdProveedore(Long idProveedore) {
		this.idProveedore = idProveedore;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
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
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public Set<Compras> getCompras() {
		return compras;
	}
	public void setCompras(Set<Compras> compras) {
		this.compras = compras;
	}
	
	
	

}

		
	
	

