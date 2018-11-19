package com.umg.programacion2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.programacion2.model.Puestos;

public interface PuestosService {

public	 String deletePuesto(HttpServletRequest request, HttpServletResponse response);
public Puestos getPuestoId(HttpServletRequest request, HttpServletResponse response);
public String updatePuesto(HttpServletRequest request, HttpServletResponse response);
}
