package com.umg.programacion2.controller;

import java.util.List;
import  org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import com.umg.programacion2.model.Menu;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.User;
import com.umg.programacion2.service.EstudianteService;
import com.umg.programacion2.service.MenuService;
import com.umg.programacion2.serviceImpl.UserServiceImpl;

@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserServiceImpl userService;
    @Autowired MenuService menuService;
    @Autowired EstudianteService estudianteService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model){
       
        return "login";
    }
    
    @RequestMapping(value={"/error"}, method = RequestMethod.GET)
    public String error(Model model){
       
    	 model.addAttribute("estudiantes", estudianteService.getAllEstudiantes()); 
         model = menuService.getAllParameter(model);
     	model.addAttribute("pagina", "Home");
        return "home";
    }


    @RequestMapping(value="/registro", method = RequestMethod.GET)
    public String registration(Model model){
        return "registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String createNewUser(HttpServletRequest request, HttpServletResponse response, Model model) {
    	User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setLastName(request.getParameter("lastName"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
           return "registro";
        }
         else {
            userService.saveUser(user);            
            return "redirect:/login";

        }
    }



    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(Model model) {
    	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         User user = userService.findUserByEmail(auth.getName());
    	
//        simpre incluir este metodo
         
        model.addAttribute("estudiantes", estudianteService.getAllEstudiantes()); 
        model = menuService.getAllParameter(model);
    	model.addAttribute("pagina", "Home");
    	
        return "home";
    }

    @RequestMapping(value="/cuenta", method = RequestMethod.GET)
    public String cambiocontra(Model model) {
    	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         User user = userService.findUserByEmail(auth.getName());
    	
//        simpre incluir este metodo
         
        model.addAttribute("user", user); 
        model = menuService.getAllParameter(model);
    	model.addAttribute("pagina", "Home");
    	
        return "cuenta";
    }
    

    
    @RequestMapping(value = "/cambioContra", method = RequestMethod.POST)
    public String changeUser(HttpServletRequest request, HttpServletResponse response, Model model) {
    	User user = userService.findUserByEmail(request.getParameter("email"));
    	user.setId(Integer.parseInt(request.getParameter("idEmpleado")));
        user.setEmail(request.getParameter("email"));
        user.setLastName(request.getParameter("lastName"));
        user.setName(request.getParameter("name"));
        logger.info(request.getParameter("antigua"));
        String updatePass="no";
        if(!request.getParameter("antigua").equals(""))
        {
        	 logger.info("parametro en blanco "+request.getParameter("antigua"));
        	 updatePass="si";
        	user.setPassword(request.getParameter("password"));
        }
 
        
       
            userService.udpateUser(user,updatePass);            
            return "redirect:/home";
        
    }
    
    @RequestMapping(value = "/validarContra", method = RequestMethod.POST)
    public @ResponseBody String validarContraS(HttpServletRequest request, HttpServletResponse response) {
    
    	
            String respuesta =userService.validatePass(request, response);            
            return respuesta;

    }

}
