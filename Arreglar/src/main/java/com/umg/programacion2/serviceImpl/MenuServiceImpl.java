package com.umg.programacion2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.User;
import com.umg.programacion2.repository.MenuRepository;
import com.umg.programacion2.service.MenuService;

@Service
public class MenuServiceImpl  implements MenuService{

	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	@Autowired MenuRepository menuRepository;
	@Autowired UserServiceImpl userService;
	
	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menu  = new ArrayList<Menu>();
		try {
			menu = menuRepository.findAll();
		}catch(Exception e) {
			logger.info("ERROR getAllMenus"+e);
		}
		
		return menu;
	}

	@Override
	public List<Menu> getAllChildren() {
		List<Menu> menu  = new ArrayList<Menu>();
		try {
			menu = menuRepository.findAllChildren();
		}catch(Exception e) {
			logger.info("ERROR getAllMenusChildren"+e);
		}
		
		return menu;
	}

	@Override
	public Model getAllParameter(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
		try {
			model.addAttribute("menu", menuRepository.findAll());
			model.addAttribute("children", menuRepository.findAllChildren());
			model.addAttribute("userName","Bienvenido " + user.getName() + " " + user.getLastName());
	    	model.addAttribute("emailUser",user.getEmail());
	    	return model;
			
		}catch(Exception e)
		{
			return model;
		}
	
	}

}
