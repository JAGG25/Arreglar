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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.service.ClienteService;
import com.umg.programacion2.service.MenuService;

@Controller
public class ClienteController {
	private static Logger logger = LoggerFactory.getLogger(ClienteController.class);
	@Autowired MenuService menuService;
	@Autowired ClienteService clienteSerice;
	
	
	@RequestMapping(value={"/ventas/clientes/listClientes"}, method = RequestMethod.GET)
    public String listClientes(Model model) {
		List<Cliente> clientes = clienteSerice.getAllCliente();
		model.addAttribute("clientes", clientes);

		 logger.info("Llegamos a lista clientes");
	 	//SIEMPRE LLAMAR A ESTA FUNCION
		    model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Clientes");
	        return "ventas/clientes/listClientes";	
    	
    }
	
	 @RequestMapping(value={"//ventas/clientes/addClientes"}, method = RequestMethod.GET)
	 public String addCliente(Model model) {
		 	List<Cliente> clientes = clienteSerice.getAllCliente();
		 	model.addAttribute("clientes", clientes);
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Clientes");
	        return "ventas/clientes/addClientes";
	    }
	 
	 @RequestMapping(value="/ventas/clientes/addCliente", method = RequestMethod.POST)
	    public String saveCliente(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = clienteSerice.saveCliente(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Clientes");
	        return "redirect:/ventas/clientes/listClientes";
	    }
	 
	 
	 @RequestMapping(value="/ventas/clientes/eliminarCliente", method = RequestMethod.POST)
		public @ResponseBody String deleteCliente(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
		{
			String respuesta = clienteSerice.deleteCliente(request, response);
			return respuesta;
			
		}
	 
	 @RequestMapping(value="/ventas/clientes/updateCliente", method = RequestMethod.GET)
	    public String updateCliente(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Cliente cliente = clienteSerice.getIdCliente(request, response);
		 	model.addAttribute("clientes", cliente);
		 	logger.info("Correo "+cliente.getCorroeElectronico());
		 	 
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	         
	       
	    	model.addAttribute("pagina", "Cliente");
	        return "ventas/clientes/updateCliente";
	    }
	 
	 @RequestMapping(value="/ventas/clientes/updateCliente", method = RequestMethod.POST)
	    public String updateCliente(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	
		 	
		 	String resp = clienteSerice.updateCliente(request, response);
		 	model.addAttribute("codigo", resp);
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Cliente");
	        return "redirect:/ventas/clientes/listClientes";
	    }
	 

	
	
}
