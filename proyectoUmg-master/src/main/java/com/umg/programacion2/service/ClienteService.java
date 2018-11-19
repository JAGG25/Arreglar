package com.umg.programacion2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.*;

public interface ClienteService {

	public List<Cliente> getAllCliente();
	public String saveCliente(HttpServletRequest request, HttpServletResponse response);
	public String deleteCliente(HttpServletRequest request, HttpServletResponse response);
	public Cliente getIdCliente(HttpServletRequest request, HttpServletResponse response);
	public String updateCliente(HttpServletRequest request, HttpServletResponse response);
	
	
}
