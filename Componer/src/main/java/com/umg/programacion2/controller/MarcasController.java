package com.umg.programacion2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.service.MarcasService;
import com.umg.programacion2.service.MenuService;

@Controller
public class MarcasController {
	private static Logger logger = LoggerFactory.getLogger(MarcasController.class);
	@Autowired MarcasService marcasService;
	@Autowired MenuService menuService;
	 
	 @RequestMapping(value={"/productos/marcas/listMarcas"}, method = RequestMethod.GET)
	    public String listMarcas(Model model) {
		 List<Marcas> marcas = marcasService.getAllMarcas();
		 model.addAttribute("marcas", marcas);
		 
		 logger.info("Llegamos a lista marcas");
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		    model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Marcas");
	        return "productos/marcas/listMarcas";
	    }
	 
	 @RequestMapping(value="/productos/marcas/addMarcas", method = RequestMethod.GET)
	    public String addMarcas(Model model) {
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 List<Marcas> marcas = marcasService.getAllMarcas();
		 	model.addAttribute("marcas", marcas);
		 	
		 	model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Marcas");
	        return "productos/marcas/addMarcas";
	    }
	 
	 @RequestMapping(value="/productos/marcas/addMarcas", method = RequestMethod.POST)
	    public String saveMarcas(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = marcasService.saveMarcas(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	model = menuService.getAllParameter(model);
	    	
		 	model.addAttribute("pagina", "Marcas");
	        return "redirect:/productos/marcas/listMarcas";
	    }
	 
	 @RequestMapping(value="/productos/marcas/eliminarMarcas", method = RequestMethod.POST)
		public @ResponseBody String deleteMarcas(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
		{
			String respuesta = marcasService.deleteMarcas(request, response);
			return respuesta;
			
		}
	 
	 @RequestMapping(value="/productos/marcas/updateMarcas", method = RequestMethod.GET)
	    public String updateMarcas(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Marcas marcas = marcasService.getMarcasId(request, response);
		 	model.addAttribute("marcas", marcas);
		 	 
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	         
	       
	    	model.addAttribute("pagina", "Marcas");
	        return "productos/marcas/updateMarcas";
	    }
	 
	 @RequestMapping(value="/productos/marcas/updateMarcas", method = RequestMethod.POST)
	    public String updateMarcas(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	
		 	
		 	String resp = marcasService.updateMarcas(request, response);
		 	model.addAttribute("codigo", resp);
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Marcas");
	        return "redirect:/productos/marcas/listMarcas";
	    }
	 

}
