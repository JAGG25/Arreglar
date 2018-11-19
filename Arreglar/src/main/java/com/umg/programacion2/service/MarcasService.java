package com.umg.programacion2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.Marcas;

public interface MarcasService {
	public List<Marcas> getAllMarcas();
	public String saveMarcas(HttpServletRequest request, HttpServletResponse response);
	public String deleteMarcas(HttpServletRequest request, HttpServletResponse response);
	public Marcas getMarcasId(HttpServletRequest request, HttpServletResponse response);
	public String updateMarcas(HttpServletRequest request, HttpServletResponse response);

}
