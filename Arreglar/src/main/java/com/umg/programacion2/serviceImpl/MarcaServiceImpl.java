package com.umg.programacion2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.programacion2.controller.EmpleadosController;
import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.MarcasRepository;
import com.umg.programacion2.service.MarcasService;

@Service
public class MarcaServiceImpl implements MarcasService{

	private static Logger logger = LoggerFactory.getLogger(MarcaServiceImpl.class);
	@Autowired MarcasRepository marcaRepository;
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Override
	public List<Marcas> getAllMarcas() {
		List<Marcas> marcas = new ArrayList<Marcas>();
		try {
			marcas = marcaRepository.findAll();
			return marcas;
		}catch(Exception e) {
			logger.info("Error saveMarcas "+e);
			return null;
		}
		
	}

	@Override
	public String saveMarcas(HttpServletRequest request, HttpServletResponse response) {
		String marca = request.getParameter("marca");
		Marcas  m = new Marcas();
		m.setMarcas(marca);
		try {
			marcaRepository.save(m);
			return codigoCorrecto;
		}catch(Exception e) {
			logger.info("Error saveMarcas "+e);
			return codigoERROR;
		}
		
	}

	@Override
	public String deleteMarcas(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Marcas marca =new Marcas();
		marca.setIdmarcas(id);
		String respuesta="";
		try {
			marcaRepository.delete(marca);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deletePuesto"+e);
		}
		return respuesta;
	}

	@Override
	public Marcas getMarcasId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Marcas marca =new Marcas();
		try {
			marca =marcaRepository.findByIdmarcas(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR deleteMarca"+e);
		}
		return marca;
	}

	@Override
	public String updateMarcas(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("marca");
		Long id= Long.parseLong(request.getParameter("id"));
		Marcas marcas = new Marcas();
		marcas.setMarcas(nombre);
		marcas.setIdmarcas(id);
		String res;
		try {
			marcaRepository.save(marcas);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Marcas"+e);	
		}
		
		return res;
	}

}
