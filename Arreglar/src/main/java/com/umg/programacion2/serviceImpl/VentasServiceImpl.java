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

import com.umg.programacion2.model.Cliente;

import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Ventas;
import com.umg.programacion2.repository.VentasRepository;
import com.umg.programacion2.service.VentasService;

@Service
public class VentasServiceImpl implements  VentasService{
	
	static Logger logger = LoggerFactory.getLogger(VentasServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Autowired VentasRepository ventasRepository;

	@Override
	public List<Ventas> getAllVentas() {
		List<Ventas> ventas = new ArrayList<Ventas>();
		try {
			ventas = ventasRepository.findAll();
			
		}catch(Exception e) {
			logger.info("Error saveVentas "+e);
			return null;
		}
		return ventas;
	}

	@Override
	public String saveVentas(HttpServletRequest request, HttpServletResponse response) {
		String noFactura = request.getParameter("noFactura");
		String serie= request.getParameter("serie");
		String fechaFactura = request.getParameter("fechaFactura");
		String fechaIngreso = request.getParameter("fechaIngreso");
		String clientes = request.getParameter("clientes");
		String empleados = request.getParameter("empleado");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaFac = null;
		Date fechaIng = null;

		try {
			fechaFac = format.parse(fechaFactura);
			fechaIng = format.parse(fechaIngreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//AGREGAR PROVEEDOR
		Cliente c = new Cliente();
		c.setIdCliente(Long.parseLong(clientes));
		
		Empleado e = new Empleado();
		e.setId(Long.parseLong(empleados));
		
		//Guardando los parametros
		
		Ventas ventas = new Ventas();
		ventas.setNoFactura(Long.parseLong(noFactura));
		ventas.setSerie(serie);
		ventas.setFechaFactura(fechaFac);
		ventas.setFechaIngreso(fechaIng);
		ventas.setCliente(c);
		ventas.setEmppleado(e);
		
		String res;
		try {
			ventasRepository.save(ventas);
			res=codigoCorrecto;
		}catch(Exception v)
		{
			res=codigoERROR;
			logger.info("Error Save Ventas"+v);	
		}
		
		return res;
	}

	@Override
	public String deleteVentas(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("idVenta"));
		Ventas ventas = new Ventas();
		ventas.setIdVenta(id);
		String respuesta = "";
		try {
			ventasRepository.delete(ventas);
			respuesta = codigoCorrecto;	
		}catch(Exception e) {
			respuesta= codigoERROR;
			logger.info("ERROR delete Ventas"+e);
		}
		 return respuesta;
	}

	@Override
	public Ventas getIdVentas(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("idVenta"));
		Ventas ventas = new Ventas();
		try {
				ventas= ventasRepository.findByIdVenta(id);
		}catch(Exception c) {
			logger.info("ERROR Get Ventas"+c);
		}
		return ventas;
	}

	@Override
	public String updateVentas(HttpServletRequest request, HttpServletResponse response) {
		String noFactura = request.getParameter("noFactura");
		String serie= request.getParameter("serie");
		String fechaFactura = request.getParameter("fechaFactura");
		String fechaIngreso = request.getParameter("fechaIngreso");
		String clientes = request.getParameter("clientes");
		String empleados = request.getParameter("empleados");
		
SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaFac = null;
		Date fechaIng = null;

		try {
			fechaFac = format.parse(fechaFactura);
			fechaIng = format.parse(fechaIngreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Cliente c = new Cliente();
		c.setIdCliente(Long.parseLong(clientes));
		
		Empleado e = new Empleado();
		e.setId(Long.parseLong(empleados));
		
		Ventas ventas = new Ventas();
		ventas.setNoFactura(Long.parseLong(noFactura));
		ventas.setSerie(serie);
		ventas.setFechaFactura(fechaFac);
		ventas.setFechaIngreso(fechaIng);
		
		
		String res;
		try {
			ventasRepository.save(ventas);
			res=codigoCorrecto;
		}catch(Exception v)
		{
			res=codigoERROR;
			logger.info("Error Update Ventas"+v);	
		}
		
		return res;
		
	}

	}
