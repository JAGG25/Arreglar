package com.umg.programacion2.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Puestos;
public interface EmpleadoService {

	public List<Puestos> getAllPuestos();
	public String savePuesto(HttpServletRequest request, HttpServletResponse response);
	public String deletePuesto(HttpServletRequest request, HttpServletResponse response);
	public Puestos getPuestoId(HttpServletRequest request, HttpServletResponse response);
	public String updatePuesto(HttpServletRequest request, HttpServletResponse response);
	
	
	public List<Empleado> getAllEmpleados();
	public String saveEmpleado(HttpServletRequest request, HttpServletResponse response);
	public Empleado getEmpleadoId(HttpServletRequest request, HttpServletResponse response);
	public String updateEmpleado(HttpServletRequest request, HttpServletResponse response);
	public String deleteEmpleado(HttpServletRequest request, HttpServletResponse response);
}
