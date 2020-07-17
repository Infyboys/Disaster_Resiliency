package com.ib.manager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@org.springframework.stereotype.Controller
@Component("MyController")
public class Controller {
	
	@Autowired
	com.ib.manager.APIController.MapAPIController MapAPIController;
	
	@Autowired
	com.ib.manager.APIController.NewsAPIController NewsAPIController;

	@RequestMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping(value = "/map", method=RequestMethod.GET)
	public String map(Model model) {
		return "hereMap";
	}
	
	@RequestMapping(value = "/get", method=RequestMethod.GET)
	public String place(Model model, String place) {
		 String location = MapAPIController.getLocation(place);
		 model.addAttribute("message", location);
		return "textResponse";
	}
	
	@RequestMapping(value = "/load", method=RequestMethod.GET)
	public String load(Model model, String disaster, String place, String start, String end) {
		 NewsAPIController.loadNews();
		 model.addAttribute("message", "success");
		return "textResponse";
	}
}
