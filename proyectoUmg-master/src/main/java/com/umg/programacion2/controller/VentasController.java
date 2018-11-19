				package com.umg.programacion2.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Compras;
import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.model.Ventas;
import com.umg.programacion2.service.ClienteService;
import com.umg.programacion2.service.ComprasService;
import com.umg.programacion2.service.EmpleadoService;
import com.umg.programacion2.service.MenuService;
import com.umg.programacion2.service.VentasService;

@Controller
public class VentasController {
	private static Logger logger = LoggerFactory.getLogger(VentasController.class);
	@Autowired MenuService menuService;
	@Autowired VentasService ventasSerice;
	@Autowired ClienteService clienteService;
	@Autowired EmpleadoService empleadoService;
	
	
	@RequestMapping(value={"/ventas/listVentas"}, method = RequestMethod.GET)
    public String listVentas(Model model) {
		List<Ventas> ventas = new ArrayList<Ventas>();
		ventas = ventasSerice.getAllVentas();
		logger.info("Estmaos aqui ");
		
		model.addAttribute("ventas", ventas);
//	 	SIEMPRE LLAMAR A ESTA FUNCION
		model = menuService.getAllParameter(model);
		
		
    	model.addAttribute("pagina", "Ventas");
        return "ventas/listVentas";
    }
	
	 @RequestMapping(value={"/ventas/addVentas"}, method = RequestMethod.GET)
	 public String addVentas(Model model) {
		 	List<Cliente> cliente = clienteService.getAllCliente();
		 	model.addAttribute("cliente", cliente);
		 	
		 	List <Empleado> empleados = empleadoService.getAllEmpleados();
		 		model.addAttribute("Empleados", empleados);
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Ventas");
	        return "ventas/addVentas";
	    }
	 
	 @RequestMapping(value="/ventas/addVentas", method = RequestMethod.POST)
	    public String saveVentas(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = ventasSerice.saveVentas(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Ventas");
	        return "redirect:/ventas/listVentas";
	    }
	 
	 @RequestMapping(value="/ventas/updateVentas", method = RequestMethod.GET)
	    public String updateVentas(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Ventas ventas = ventasSerice.getIdVentas(request, response);
		 	model.addAttribute("Ventas", ventas);
		 	 
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	         
	       
	    	model.addAttribute("pagina", "Ventas");
	        return "ventas/updateVentas";
	    }
	 
	 @RequestMapping(value="/ventas/updateVentas", method = RequestMethod.POST)
	    public String updateVentas(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	
		 	
		 	String resp = ventasSerice.updateVentas(request, response);
		 	model.addAttribute("codigo", resp);
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Ventas");
	        return "redirect:/ventas/listVentas";
	    }

	 
	 
	
	
	
}
