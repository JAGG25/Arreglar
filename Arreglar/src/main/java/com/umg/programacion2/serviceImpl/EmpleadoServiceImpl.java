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

import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.EmpleadoRepository;
import com.umg.programacion2.repository.PuestoRepository;
import com.umg.programacion2.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	
	@Autowired PuestoRepository puestoRepository;
	@Autowired EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Puestos> getAllPuestos() {
		List<Puestos> puestos = new ArrayList<Puestos>();
		try {
			puestos =puestoRepository.findAll();
			
		
		}catch(Exception e)
		{
			puestos = null;
			logger.info("Error "+e);
		}
		return puestos;
	}

	@Override
	public String savePuesto(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		Puestos puesto = new Puestos();
		puesto.setNombre(nombre);
		String res;
		try {
			puestoRepository.save(puesto);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error SavePuesto"+e);	
		}
		
		return res;
	}

	@Override
	public String deletePuesto(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos	 puesto = new Puestos();
		puesto.setIdPuesto(id);
		String respuesta="";
		try {
			puestoRepository.delete(puesto);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deletePuesto"+e);
		}
		return respuesta;
	}


	@Override
	public Puestos getPuestoId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos	 puesto = new Puestos();
		try {
			puesto =puestoRepository.findByIdPuesto(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR deletePuesto"+e);
		}
		return puesto;
	}

	@Override
	public String updatePuesto(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos puesto = new Puestos();
		puesto.setNombre(nombre);
		puesto.setIdPuesto(id);
		String res;
		try {
			puestoRepository.save(puesto);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Empleado"+e);	
		}
		
		return res;
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		List<Empleado> puestos = new ArrayList<Empleado>();
		try {
			puestos =empleadoRepository.findAll();
		
		}catch(Exception e)
		{
			puestos = null;
			logger.info("Error getEmpleado "+e);
		}
		return puestos;
	}

	@Override
	public String saveEmpleado(HttpServletRequest request, HttpServletResponse response) {
		String nombres = request.getParameter("nombres");
		String apellidos= request.getParameter("apellidos");
		String direccion= request.getParameter("direccion");
		String telefono= request.getParameter("telefono");
		String dpi= request.getParameter("dpi");
		String genero= request.getParameter("genero");
		String fechaNacimiento= request.getParameter("fecha_nacimiento");
		String fechaIngreso= request.getParameter("fecha_ingreso");
		String fecha_inicio= request.getParameter("fecha_inicio");
		String puesto= request.getParameter("puesto");
		Boolean gener = false;
		if (genero.equals("1"))
		{
			gener = true;
		}
		logger.info("genero "+genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaNac = null;
		Date fechaIng = null;
		Date fechaIni = null;
		try {
			fechaNac = format.parse(fechaNacimiento);
			fechaIng = format.parse(fechaIngreso);
			fechaIni = format.parse(fecha_inicio);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		Agregando puesto 
		Puestos p = new Puestos();
		p.setIdPuesto(Long.parseLong(puesto));
		
//		Guardando todos los parametros en empleado
		
		Empleado empleado = new Empleado();
		empleado.setNombres(nombres);
		empleado.setApellidos(apellidos);
		empleado.setDireccion(direccion);
		empleado.setDpi(dpi);
		empleado.setFechaIngreso(fechaIng);
		empleado.setFechaInicio(fechaIni);
		empleado.setFechaNacimiento(fechaNac);
		empleado.setPuesto(p);
		empleado.setGenero(gener);
		empleado.setTelefono(telefono);
		
		String res;
		try {
			empleadoRepository.save(empleado);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Save Empleado"+e);	
		}
		
		return res;
	}

	

	@Override
	public Empleado getEmpleadoId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Empleado	 empleado = new Empleado();
		try {
			empleado =empleadoRepository.findByIdEmpleado(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR Get Empleado"+e);
		}
		return empleado;
	}

	@Override
	public String updateEmpleado(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		String nombres = request.getParameter("nombres");
		String apellidos= request.getParameter("apellidos");
		String direccion= request.getParameter("direccion");
		String telefono= request.getParameter("telefono");
		String dpi= request.getParameter("dpi");
		String genero= request.getParameter("genero");
		String fechaNacimiento= request.getParameter("fecha_nacimiento");
		String fechaIngreso= request.getParameter("fecha_ingreso");
		String fecha_inicio= request.getParameter("fecha_inicio");
		String puesto= request.getParameter("puesto");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Boolean gener = false;
		if (genero.equals("1"))
		{
			gener = true;
		}
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaNac = null;
		Date fechaIng = null;
		Date fechaIni = null;
		try {
			fechaNac = format.parse(fechaNacimiento);
			fechaIng = format.parse(fechaIngreso);
			fechaIni = format.parse(fecha_inicio);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		Agregando puesto 
		Puestos p = new Puestos();
		p.setIdPuesto(Long.parseLong(puesto));
		
//		Guardando todos los parametros en empleado
		
		Empleado empleado = new Empleado();
		empleado.setId(id);
		empleado.setNombres(nombres);
		empleado.setApellidos(apellidos);
		empleado.setDireccion(direccion);
		empleado.setDpi(dpi);
		empleado.setFechaIngreso(fechaIng);
		empleado.setFechaInicio(fechaIni);
		empleado.setFechaNacimiento(fechaNac);
		empleado.setPuesto(p);
		empleado.setGenero(gener);
		empleado.setTelefono(telefono);
		
		String res;
		try {
			empleadoRepository.save(empleado);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Empleado"+e);	
		}
		
		return res;
	}

	@Override
	public String deleteEmpleado(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Empleado empleado = new Empleado();
		empleado.setId(id);
		String respuesta="";
		try {
			empleadoRepository.delete(empleado);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR delete Empleado"+e);
		}
		return respuesta;
	}

	
}
