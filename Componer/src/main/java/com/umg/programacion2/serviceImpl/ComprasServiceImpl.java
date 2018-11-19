package com.umg.programacion2.serviceImpl;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.umg.programacion2.model.Compras;
import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Proveedores;
import com.umg.programacion2.repository.ComprasRepository;

import com.umg.programacion2.service.ComprasService;

@Service
public class ComprasServiceImpl implements ComprasService {
	
	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Autowired ComprasRepository comprasRepository;
	

	@Override
	public List<Compras> getAllCompras() {
		List<Compras> compras = new ArrayList<Compras>();
		try {
			compras= comprasRepository.findAll();
			return compras;
		}catch(Exception e) {
			
			logger.info("Error Compras"+e);
			return null;
		}

		
	}

	@Override
	public String saveCompras(HttpServletRequest request, HttpServletResponse response) {
		String no_orden_compra = request.getParameter("no_orden_compra");
		String proveedores= request.getParameter("proveedores");
		String fechaOrden = request.getParameter("fechaOrden");
		String fechaIngreso = request.getParameter("fecha_ingreso");
		String producto = request.getParameter("producto");
		String cantidad= request.getParameter("cantidad");
		String precio_costo_unitario = request.getParameter("precio_costo_unitario");
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaOrd = null;
		Date fechaIng = null;

		try {
			fechaOrd = format.parse(fechaOrden);
			fechaIng = format.parse(fechaIngreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//AGREGAR PROVEEDOR
		Proveedores p = new Proveedores();
		p.setIdProveedore(Long.parseLong(proveedores));
		
		//Agregar Producto
		Productos pr = new Productos();
		pr.setIdProducto(Long.parseLong(producto));
		
	
		//Guardando los parametros
		
		Compras compras = new Compras();
		compras.setNo_orden_compra(no_orden_compra);
		compras.setProveedoesr(p);
		compras.setFechaOrden(fechaOrd);
		compras.setFechaIngreso(fechaIng);
		compras.setCantidad(cantidad);
		compras.setPrecio_costo_unitario(precio_costo_unitario);
		compras.setProducto(pr);
		
		
		
		String res;
		try {
			comprasRepository.save(compras);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Save Compras"+e);	
		}
		
		return res;
	}
		
		
		
	

	@Override
	public String deleteCompras(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("idCompras"));
		Long idcompra = Long.parseLong(request.getParameter("idcompradetalle"));
		Compras compras = new Compras();
		compras.setId(id);
		compras.setIdcompradetalle(idcompra);
		String respuesta = "";
		try {
			comprasRepository.delete(compras);
			respuesta = codigoCorrecto;	
		}catch(Exception e) {
			respuesta= codigoERROR;
			logger.info("ERROR delete Compras"+e);
		}
		 return respuesta;
	}

	@Override
	public Compras getIdCompras(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Long idcompra= Long.parseLong(request.getParameter("idcompradetalle"));
		Compras compras = new Compras();
		try {
				compras= comprasRepository.findByIdCompras(id);
				compras = comprasRepository.findByIdCompras(idcompra);
		}catch(Exception e) {
			logger.info("ERROR Get Compras"+e);
		}
		return compras;
	}

	@Override
	public String updateCompras(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("idCompras"));
		Long idcompra = Long.parseLong(request.getParameter("idcompradetalle"));
		String no_orden_compra = request.getParameter("no_orden_compra");
		String proveedores= request.getParameter("proveedores");
		String fechaOrden = request.getParameter("fechaOrden");
		String fechaIngreso = request.getParameter("fechaIngreso");
		String producto = request.getParameter("producto");
		String cantidad= request.getParameter("cantidad");
		String precio_costo_unitario = request.getParameter("precio_costo_unitario");
		
	
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		Date fechaOrd = null;
		Date fechaIng = null;
		
		try {
			fechaOrd = format.parse(fechaOrden);
			fechaIng= format.parse(fechaIngreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Proveedores p = new Proveedores();
		p.setIdProveedore(Long.parseLong(proveedores));
		
		//Agregar Producto
				Productos pr = new Productos();
				pr.setIdProducto(Long.parseLong(producto));
		
		Compras compras = new Compras();
		compras.setId(id);
		compras.setIdcompradetalle(idcompra);
		compras.setNo_orden_compra(no_orden_compra);
		compras.setProveedoesr(p);
		compras.setFechaOrden(fechaOrd);
		compras.setFechaIngreso(fechaIng);
		compras.setCantidad(cantidad);
		compras.setProducto(pr);
		compras.setPrecio_costo_unitario(precio_costo_unitario);
		
		
		
		
		String res;
		try {
			comprasRepository.save(compras);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Compras"+e);	
		}
		
		return res;
		
		
		

		
	}

}
