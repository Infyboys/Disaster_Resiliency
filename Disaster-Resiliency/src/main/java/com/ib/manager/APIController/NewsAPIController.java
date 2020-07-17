package com.ib.manager.APIController;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ib.manager.NYTBeans.NewsResult;


@Component("NewsAPIController")
public class NewsAPIController {
	
	@Autowired
	com.ib.manager.DAO.JDBCHandler JDBCHandler;
	
	private String mapAPIKey= "HjLDkAkEEkgV0JcPMMGqlX4PMm57PAs4";
	
	public void loadNews() {
		try {
			String newsJSON = getNews("flood", "Bhubaneswar", "20120101", "20200101");
			
			//LinkedTreeMap person = gson.fromJson(newsJSON, LinkedTreeMap.class);
			//newsJSON = "{\"status\": \"OK\",\"copyright\": \"Copyright (c) 2020 The New York Times Company. All Rights Reserved.\"}";
    	
			ObjectMapper mapper = new ObjectMapper();
			NewsResult result = mapper.readValue(newsJSON, NewsResult.class);
			
			System.out.println(result.getStatus());
			
			//JDBCHandler.addData(1, 1, "20200101", "cyclone", "www.yahoo.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNews(String disaster, String place, String start, String end)
	{
	    String uri = "https://api.nytimes.com/svc/search/v2/articlesearch.json?";
	    
	    uri += "api-key=" + mapAPIKey;
	    uri += "&q=" + disaster + "+" + place;
	    uri += "&begin_date=" + start;
	    uri += "&end_date=" + end;
	    uri += "&fl=web_url,headline,pub_date";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	    return result;
	}
}
