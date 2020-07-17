package com.ib.manager.APIController;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("MapAPIController")
public class MapAPIController {

	public String getLocation(String place)
	{
	    String uri = "https://geocode.search.hereapi.com/v1/geocode?maxresults=1&apiKey=CTPUU0kWzEUjDPiVh6V-QzlDaxh0LfzlfpRweaI193c";
	    
	    uri += "&q="+ place;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	    return result;
	}
}
