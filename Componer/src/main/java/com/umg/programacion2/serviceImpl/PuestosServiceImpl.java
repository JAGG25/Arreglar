package com.umg.programacion2.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.PuestoRepository;
import com.umg.programacion2.service.PuestosService;
@Service
public class PuestosServiceImpl implements PuestosService
{

	private static Logger logger = LoggerFactory.getLogger(PuestosServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Autowired PuestoRepository puestoRepository;
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
	public String updatePuesto(HttpServletRequest request, HttpServletResponse response){
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

}
