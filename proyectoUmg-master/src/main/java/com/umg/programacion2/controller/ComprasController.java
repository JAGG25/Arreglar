package com.umg.programacion2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Compras;
import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.service.ClienteService;
import com.umg.programacion2.service.ComprasService;
import com.umg.programacion2.service.MenuService;

@Controller
public class ComprasController {
	@Autowired MenuService menuService;
	@Autowired ComprasService comprasSerice;
	
	
	@RequestMapping(value={"/compras/listCompras"}, method = RequestMethod.GET)
    public String listCompras(Model model) {
		List<Compras> compras = new ArrayList<Compras>();
		compras = comprasSerice.getAllCompras();
		
		model.addAttribute("compras", compras);
//	 	SIEMPRE LLAMAR A ESTA FUNCION
		model = menuService.getAllParameter(model);
		
		
    	model.addAttribute("pagina", "Compras");
        return "compras/listCompras";
    }
	
	 @RequestMapping(value={"/compras/addCompras"}, method = RequestMethod.GET)
	 public String addCompras(Model model) {
		 	List<Compras> compras = comprasSerice.getAllCompras();
		 	model.addAttribute("compras", compras);
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Compras");
	        return "compras/addCompras";
	    }
	 
	 @RequestMapping(value="/compras/addCompras", method = RequestMethod.POST)
	    public String saveCompras(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = comprasSerice.saveCompras(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Compras");
	        return "redirect:/compras/listCompras";
	    }
	 
	 @RequestMapping(value="/compras/updateCompras", method = RequestMethod.GET)
	    public String updateCompras(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Compras compras = comprasSerice.getIdCompras(request, response);
		 	model.addAttribute("compras", compras);
		 	 
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	         
	       
	    	model.addAttribute("pagina", "Compras");
	        return "compras/updateCompras";
	    }
	 
	 @RequestMapping(value="/compras/updateCompras", method = RequestMethod.POST)
	    public String updateCompras(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	
		 	
		 	String resp = comprasSerice.updateCompras(request, response);
		 	model.addAttribute("codigo", resp);
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Compras");
	        return "redirect:/compras/listCompras";
	    }

	 
	 
	
	
	
}
