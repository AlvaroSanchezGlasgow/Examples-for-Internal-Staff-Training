package com.charts.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charts.demo.beans.Request;
import com.charts.demo.database.RequestRepository;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RequestRepository requestRepository;

	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws Exception {
		logger.debug("HomeController -");
		
	               
         
		List<Integer> oListAmmount = new ArrayList<Integer>();
		List<String> oListName = new ArrayList<String>();
		
		
		try {
			
		for (Request request : requestRepository.findAll()) {
			oListAmmount.add(Integer.parseInt(request.getQuantity()));
			oListName.add(request.getName());
		}
			
		}catch(Exception ex) {
			logger.error("HomeController - Error: "+ex.getMessage());
			throw new Exception("Error: " + ex.getMessage());
		}
		
		 ObjectMapper mapper = new ObjectMapper();
		 
		 
		  model.addAttribute("data",
				  mapper.writeValueAsString(oListAmmount));
		 
		//  model.addAttribute("labels", oListName.toString().replace(",", "\",\"").replace("[", "[\"").replace("]", "\"]"));
		  
		  //System.out.println(oListName.toString().replace(",", "\",\"").replace("[", "[\"").replace("]", "\"]"));
		 
		return "index";
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/line", method = RequestMethod.GET)
	public String line(Model model) throws Exception {
		logger.debug("HomeController -");
		
		List<Integer> oListAmmount = new ArrayList<Integer>();
		List<String> oListName = new ArrayList<String>();
		
		
		try {
			
		for (Request request : requestRepository.findAll()) {
			oListAmmount.add(Integer.parseInt(request.getQuantity()));
			oListName.add(request.getName());
		}
			
		}catch(Exception ex) {
			logger.error("HomeController - Error: "+ex.getMessage());
			throw new Exception("Error: " + ex.getMessage());
		}
		
		 ObjectMapper mapper = new ObjectMapper();
		 
		 
		  model.addAttribute("data",
				  mapper.writeValueAsString(oListAmmount));
		
		return "lineChart";
	}
	
	

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pie", method = RequestMethod.GET)
	public String pie(Model model) throws Exception {
		logger.debug("HomeController -");
		
		List<Integer> oListAmmount = new ArrayList<Integer>();
		List<String> oListName = new ArrayList<String>();
		
		
		try {
			
		for (Request request : requestRepository.findAll()) {
			oListAmmount.add(Integer.parseInt(request.getQuantity()));
			oListName.add(request.getName());
		}
			
		}catch(Exception ex) {
			logger.error("HomeController - Error: "+ex.getMessage());
			throw new Exception("Error: " + ex.getMessage());
		}
		
		 ObjectMapper mapper = new ObjectMapper();
		 
		 
		  model.addAttribute("data",
				  mapper.writeValueAsString(oListAmmount));
		//System.out.println(b);
		  
		return "pieChart";
	}
	
	
	
	
}
