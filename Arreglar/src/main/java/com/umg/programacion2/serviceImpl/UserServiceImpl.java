package com.umg.programacion2.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umg.programacion2.controller.EmpleadosController;
import com.umg.programacion2.model.Role;
import com.umg.programacion2.model.User;
import com.umg.programacion2.repository.RoleRepository;
import com.umg.programacion2.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
    	
 
    		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    
        
        user.setActive(1);
        Role userRole = roleRepository.findByRole("CLIENTE");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
}
    public String validatePass(HttpServletRequest request, HttpServletResponse response)
    {
    	
    	logger.info("Id"+Integer.parseInt(request.getParameter("antigua")));
    	User user = userRepository.findById(Integer.parseInt(request.getParameter("id")));
    	String res="001";
    	if(!bCryptPasswordEncoder.matches(request.getParameter("antigua"), user.getPassword()))
    	{
    	res="000";	
    	}
    	
		return res;
    	
    }
    public void udpateUser(User user, String updatePass)
    {
    	if(updatePass=="si")
    	{
    		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	}
    	 userRepository.save(user);
    	
    }

}
