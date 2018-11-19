package com.umg.programacion2.service;

import java.util.List;

import org.springframework.ui.Model;

import com.umg.programacion2.model.*;

public interface MenuService {

	List<Menu> getAllMenu();
	List<Menu> getAllChildren();
	Model  getAllParameter(Model model);
	
}
