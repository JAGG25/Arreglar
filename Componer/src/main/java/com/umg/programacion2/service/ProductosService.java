package com.umg.programacion2.service;

import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.umg.programacion2.model.Productos;

public interface ProductosService {

	
	
	public List<Productos> getAllProductos();
	public String saveProductos(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException;
	public Productos getProductosId(HttpServletRequest request, HttpServletResponse response);
	public String updateProductos(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException;
	public String deleteProductos(HttpServletRequest request, HttpServletResponse response);
	
}