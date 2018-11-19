package com.umg.programacion2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.*;

public interface ComprasService {

	public List<Compras> getAllCompras();
	public String saveCompras(HttpServletRequest request, HttpServletResponse response);
	public String deleteCompras(HttpServletRequest request, HttpServletResponse response);
	public Compras getIdCompras(HttpServletRequest request, HttpServletResponse response);
	public String updateCompras(HttpServletRequest request, HttpServletResponse response);
	
	
}
