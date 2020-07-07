package com.ib.springbootstarter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@Component("MyController")
public class Controller {
	
	@Autowired
	com.ib.APIController.MapAPIController MapAPIController;

	@RequestMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/map")
	public String map(Model model) {
		 model.addAttribute("name", "raj");
		return "hereMap";
	}
	
	@RequestMapping("/get")
	public String place(Model model, String place) {
		 String location = MapAPIController.getLocation(place);
		 model.addAttribute("message", location);
		return "textResponse";
	}
}
