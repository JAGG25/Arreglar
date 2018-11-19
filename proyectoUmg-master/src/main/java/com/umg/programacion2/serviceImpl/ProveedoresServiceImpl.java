package com.umg.programacion2.serviceImpl;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Proveedores;
import com.umg.programacion2.repository.MarcasRepository;
import com.umg.programacion2.repository.ProductosRepository;
import com.umg.programacion2.repository.ProveedoresRepository;
import com.umg.programacion2.service.ProductosService;
import com.umg.programacion2.service.ProveedoresService;
@Service
public class ProveedoresServiceImpl implements ProveedoresService{

	private static Logger logger = LoggerFactory.getLogger(ProveedoresServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	//private static final String Puestos = null;
	
	
	@Autowired ProveedoresRepository proveedoresRepository;
	@Override
	public List<Proveedores> getAllProveedor() {
		List<Proveedores> proveedores = new ArrayList<Proveedores>();
		try {
			proveedores = proveedoresRepository.findAll();
			
		}catch(Exception e) {
			logger.info("Error saveProveedores "+e);
			return null;
		}
		return proveedores;
	}
	@Override
	public String saveProveedores(HttpServletRequest request, HttpServletResponse response) {
		String proveedor= request.getParameter("proveedor");
		String nit= request.getParameter("nit");
		String direccion= request.getParameter("direccion");
		String telefono= request.getParameter("telefono");
		
//		Agregando puesto 
		//Marcas  m = new Marcas();
		//m.setIdmarcas(Long.parseLong(marca));
		
//		Guardando todos los parametros en Proveedores
		
		Proveedores proveedores = new Proveedores();
		proveedores.setProveedor(proveedor);
		proveedores.setNit(nit);
		proveedores.setDireccion(direccion);
		proveedores.setTelefono(telefono);
		String res;
		try {
			proveedoresRepository.save(proveedores);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Save Proveedores"+e);	
		}
		
		return res;
	}
	@Override
	public Proveedores getProveedoresId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Proveedores proveedores =new Proveedores();
		try {
			proveedores =proveedoresRepository.findByIdProveedores(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR Get Proveedores"+e);
		}
		return proveedores;
	}
	@Override
	public String updateProveedores(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		String proveedor= request.getParameter("proveedor");
		String nit= request.getParameter("nit");
		String direccion= request.getParameter("direccion");
		String telefono= request.getParameter("telefono");
		logger.info("Proveedores "+proveedor);

		
//		Agregando puesto 	
		
		//Marcas  m = new Marcas();
		//m.setIdmarcas(Long.parseLong(marca));
		
//		Guardando todos los parametros en empleado
		
		Proveedores proveedores = new Proveedores();
		proveedores.setIdProveedore(id);
		proveedores.setProveedor(proveedor);
		proveedores.setNit(nit);
		proveedores.setDireccion(direccion);
		proveedores.setTelefono(telefono);
		String res;
		
		try {
			proveedoresRepository.save(proveedores);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Proveedores"+e);	
		}
		
		return res;

	}
	@Override
	public String deleteProveedores(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Proveedores proveedores =new Proveedores();
		proveedores.setIdProveedore(id);
		String respuesta="";
		try {
			proveedoresRepository.delete(proveedores);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deleteProveedores"+e);
		}
		return respuesta;
	}
	


	
}