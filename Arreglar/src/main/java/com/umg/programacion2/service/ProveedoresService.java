package com.umg.programacion2.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Proveedores;

public interface ProveedoresService {

	
	
	public List<Proveedores> getAllProveedor();
	public String saveProveedores(HttpServletRequest request, HttpServletResponse response);
	public Proveedores getProveedoresId(HttpServletRequest request, HttpServletResponse response);
	public String updateProveedores(HttpServletRequest request, HttpServletResponse response);
	public String deleteProveedores(HttpServletRequest request, HttpServletResponse response);
	
}
