package com.test.everis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.everis.service.interfaces.UsersService;
import com.google.gson.Gson;
import com.test.everis.dto.UsersDTO;

/**
 * Controller used to redirect the http call to the initial index view
 * @author asanchga
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static final String USERS_LIST = "users";
	private static final String INDEX = "index";
	
	@Autowired
	Gson gson;
	
	@Autowired
	UsersService userService;
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userList() throws Exception {
		logger.debug("HomeController - @RequestMapping(value = \"/\")");
		
		List oListResult = new ArrayList();
		ModelAndView modelAndView = new ModelAndView("index");
		
		try {
		oListResult = userService.getAllUsers();
		logger.debug("oListResult-->"+oListResult.toString());
		}catch(Exception ex) {
			logger.error("HomeController - Error: "+ex.getMessage());
			throw new Exception("Error: " + ex.getMessage());
		}
		
		modelAndView.addObject(USERS_LIST, oListResult);
		return modelAndView;
	}
	
	@RequestMapping(value = "/save")
	public ModelAndView save(@RequestParam("userID") String userID, @RequestParam("userName") String userName,@RequestParam("userSurname") String userSurname,@RequestParam("userRole") String userRole) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index");
		List oListResult = new ArrayList();
		try {
			
			userService.createNewUser(userID,userName,userSurname,userRole);
			
			logger.info("Successfully saved Users.");
		} catch (Exception ex) {
			// Debug error
			logger.info("Error -->" + ex.getMessage());
			// responseJSON = "[{\"Error\":\"" + ex.getMessage() + "\"}]";
			throw new Exception("Error: " + ex.getMessage());
		}
		
		oListResult = userService.getAllUsers();
		modelAndView.addObject(USERS_LIST, oListResult);

		return modelAndView;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value = "id") final String id, final HttpServletRequest request) throws Exception {
		try {
			
			userService.deleteUsers(id);
			
			logger.info("Successfully delete Users.");
		} catch (Exception ex) {
			// Debug error
			logger.debug("Error -->" + ex.getMessage());
			// responseJSON = "[{\"Error\":\"" + ex.getMessage() + "\"}]";
			throw new Exception("Error: " + ex.getMessage());
		}
		return new ModelAndView("redirect:/");
		//return INDEX;
	}
	
	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/admin")
	public ModelAndView admin() throws Exception {
		try {
			
			String test = null;
			//System.out.println("Testing-->"+test.substring(0, 5));
		}catch(Exception ex) {
			logger.debug("Error -->" + ex.getMessage());
			// responseJSON = "[{\"Error\":\"" + ex.getMessage() + "\"}]";
			throw new Exception("Error: " + ex.getMessage());
		}
				
		return new ModelAndView("admin");
	}
		
		
	
	
	
}
