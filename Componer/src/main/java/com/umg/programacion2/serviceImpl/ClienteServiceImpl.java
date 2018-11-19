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
import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.ClienteRepostory;
import com.umg.programacion2.repository.PuestoRepository;
import com.umg.programacion2.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{

	
	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Autowired ClienteRepostory clienteRepository;
	
	@Override
	public List<Cliente> getAllCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes =clienteRepository.findAll();
		
		}catch(Exception e)
		{
			clientes = null;
			String c = null;
			logger.info("Error getCliente "+c);
		}
		return clientes;
	}
		

	

	@Override
	public String saveCliente(HttpServletRequest request, HttpServletResponse response) {
		String nombres = request.getParameter("nombres");
		String apellidos= request.getParameter("apellidos");
		String nit= request.getParameter("nit");
		String genero= request.getParameter("genero");
		String telefono= request.getParameter("telefono");
		String correoElectronico= request.getParameter("correoElectronico");
		String fechaIngreso= request.getParameter("fechaIngreso");
		Boolean gener = false;
		if (genero.equals("1"))
		{
			gener = true;
		}
		logger.info("genero "+genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaIng = null;
		try {
			fechaIng = format.parse(fechaIngreso);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

//		Guardando todos los parametros en empleado
		
		Cliente cliente = new Cliente();
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setNit(nit);
		cliente.setGenero(gener);
		cliente.setTelefono(telefono);
		cliente.setCorroeElectronico(correoElectronico);
		cliente.setFechaIngreso(fechaIng);
		String res;
		
		
		try {
			clienteRepository.save(cliente);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			String c = null;
			logger.info("Error Save Clientes"+c);	
		}
		
		return res;
	}



	@Override
	public String deleteCliente(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Cliente clientes =new Cliente();
		clientes.setIdCliente(id);
		String respuesta="";
		try {
			clienteRepository.delete(clientes);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deleteClientes"+e);
		}
		return respuesta;
	}




	@Override
	public Cliente getIdCliente(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Cliente clientes =new Cliente();
		try {
			clientes =clienteRepository.findByIdCliente(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR Get Cliente"+e);
		}
		return clientes;
	}




	@Override
	public String updateCliente(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		String nombres = request.getParameter("nombres");
		String apellidos= request.getParameter("apellidos");
		String nit = request.getParameter("nit");
		String genero= request.getParameter("genero");
		String telefono= request.getParameter("telefono");
		String correoElectronico= request.getParameter("correo_electronico");
		String fechaIngreso= request.getParameter("fechaIngreso");
		Boolean gener = false;
		if (genero.equals("1"))
		{
			gener = true;
		}
		logger.info("genero "+genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		Date fechaIng = null;
		try {
			fechaIng = format.parse(fechaIngreso);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		Agregando puesto 
		//Puestos p = new Puestos();
		//p.setIdPuesto(Long.parseLong(puesto));
		
//Guardando todos los parametros en Cliente
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setNit(nit);
		cliente.setGenero(gener);
		cliente.setTelefono(telefono);
		cliente.setCorroeElectronico(correoElectronico);
		cliente.setFechaIngreso(fechaIng);
		String res;
		

		try {
			clienteRepository.save(cliente);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Cliente"+e);	
		}
		
		return res;

	
	
	}
	
	

	
}
