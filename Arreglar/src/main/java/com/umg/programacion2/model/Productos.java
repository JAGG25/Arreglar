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
@Table(name="productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idProducto")
	private Long idProducto;
	@Column(name="producto")
	private String producto;
	@Column(name="Descripcion")
	private String Descripcion;
	@Column(name="imagen",length=100000000)
	private String imagen;
	@Column(name="precio_costo")
	private String precio_costo;
	@Column(name="precio_venta")
	private String precio_venta;
	@Column(name="existencia")
	private String existencia;
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="idMarca")
	private Marcas marcas;
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="productos")
	//@JsonManagedReference
	//Set<Ventas> ventas = new HashSet<Ventas>();
	
	
	
	
	
	public Productos() {
		super();
	}
	
	
	public Productos(Long idProducto, String producto, String descripcion, String imagen, String precio_costo,
			String precio_venta, String existencia, Date fecha_ingreso, Marcas marcas) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;
		Descripcion = descripcion;
		this.imagen = imagen;
		this.precio_costo = precio_costo;
		this.precio_venta = precio_venta;
		this.existencia = existencia;
		this.fecha_ingreso = fecha_ingreso;
		this.marcas = marcas;
	}









	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio_costo() {
		return precio_costo;
	}
	public void setPrecio_costo(String precio_costo) {
		this.precio_costo = precio_costo;
	}
	public String getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(String precio_venta) {
		this.precio_venta = precio_venta;
	}
	public String getExistencia() {
		return existencia;
	}
	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public Marcas getMarcas() {
		return marcas;
	}
	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}
	public void setPrecio_costo1(String precio_costo2) {
		// TODO Auto-generated method stub
		
	}

		
	
		
	}

