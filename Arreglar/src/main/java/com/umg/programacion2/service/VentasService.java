package com.umg.programacion2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.*;

public interface VentasService {

	public List<Ventas> getAllVentas();
	public String saveVentas(HttpServletRequest request, HttpServletResponse response);
	public String deleteVentas(HttpServletRequest request, HttpServletResponse response);
	public Ventas getIdVentas(HttpServletRequest request, HttpServletResponse response);
	public String updateVentas(HttpServletRequest request, HttpServletResponse response);
	
	
}
