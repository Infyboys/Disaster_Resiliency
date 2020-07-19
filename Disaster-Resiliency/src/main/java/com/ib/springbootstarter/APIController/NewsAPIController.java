package com.ib.springbootstarter.APIController;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ib.springbootstarter.beans.Article;

@Component("NewsAPIController")
public class NewsAPIController {
	
	private String mapAPIKey= "HjLDkAkEEkgV0JcPMMGqlX4PMm57PAs4";
	
	public Article getNews(String disaster, String place)
	{
	    String uri = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
	    
	    uri += "?api-key=" + mapAPIKey;
	    uri += "&q=" + disaster + "+" + place;
	   // uri += "&begin_date=" + start;
	   // uri += "&end_date=" + end;
	    uri += "&fl=web_url,headline";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    Article result = restTemplate.getForObject(uri, Article.class);
	    
	    System.out.println(result.toString());
	    return result;
	}
}
