package com.ib.springbootstarter.APIController;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("NewsAPIController")
public class NewsAPIController {
	
	private String mapAPIKey= "HjLDkAkEEkgV0JcPMMGqlX4PMm57PAs4";
	
	public String getNews(String disaster, String place, String start, String end)
	{
	    String uri = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
	    
	    uri += "api-key=" + mapAPIKey;
	    uri += "&q=" + disaster + "+" + place;
	    uri += "&begin_date=" + start;
	    uri += "&end_date=" + end;
	    uri += "&fl=web_url,headline";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	    return result;
	}
}
