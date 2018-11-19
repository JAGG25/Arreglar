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
import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Proveedores;
import com.umg.programacion2.service.MarcasService;
import com.umg.programacion2.service.MenuService;
import com.umg.programacion2.service.ProductosService;
import com.umg.programacion2.service.ProveedoresService;


@Controller
public class ProveedoresController {

	private static Logger logger = LoggerFactory.getLogger(ProveedoresController.class);
	@Autowired ProveedoresService proveedoresService;
	@Autowired MenuService menuService;

	 
	 
	 @RequestMapping(value={"/compras/proveedor/listProveedores"}, method = RequestMethod.GET)
	    public String listProductos(Model model) {
		 List<Proveedores> proveedor = proveedoresService.getAllProveedor();
		 model.addAttribute("proveedores", proveedor);
		 
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//       simpre incluir este metodo
            model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Proveedores");
	        return "compras/proveedor/listProveedores";
	    }
	 
	 @RequestMapping(value={"/compras/proveedor/addProveedores"}, method = RequestMethod.GET)
	 public String addProductos(Model model) {
		 
//		    LLAMANDO A LAS compras PARA LA VISTA
		   // List<Compras> compras = comprasService.getAllCompras();
		 	
		 	//model.addAttribute("compras", compras);
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "proveedores");
	        return "compras/proveedor/addProveedores";
	    }
	 
	 @RequestMapping(value="/compras/proveedor/addProveedores", method = RequestMethod.POST)
	    public String saveProveedores(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = proveedoresService.saveProveedores(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "roveedores");
	        return "redirect:/compras/proveedor/listProveedores";
	    }
	 

	 	@RequestMapping(value="/compras/proveedor/updateProveedores", method = RequestMethod.GET)
	    public String findProductos(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	
//		    LLAMANDO A LAS MARCAS PARA LA VISTA
		   // List<Marcas> marcas = marcaService.getAllMarcas();
		 	
		 	//model.addAttribute("marcas", marcas);
		 	
		 	Proveedores resp = proveedoresService.getProveedoresId(request, response);
		 	model.addAttribute("proveedores", resp);
		 	logger.info("Provverdor "+resp.getProveedor());

		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Proveedores");
	        return "compras/proveedor/updateProveedores";
	    }
	 	
	 	@RequestMapping(value="/compras/proveedor/updateProveedores", method = RequestMethod.POST)
	    public String updateProveedores(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = proveedoresService.updateProveedores(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
//	        simpre incluir este metodo
	         model = menuService.getAllParameter(model);
	    	model.addAttribute("pagina", "Productos");
	        return "redirect:/compras/proveedor/listProveedores";
	    }
	 	
	 	@RequestMapping(value="/compras/proveedor/eliminarProveedores", method = RequestMethod.POST)
		public @ResponseBody String deleteProveedores(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
		{
			String respuesta = proveedoresService.deleteProveedores(request, response);
			return respuesta;
			
		}
	 
}
