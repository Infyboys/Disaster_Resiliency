package com.ib.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ib.springbootstarter.APIController.NewsAPIController;
import com.ib.springbootstarter.beans.Article;
import com.ib.springbootstarter.beans.Disaster;
import com.ib.springbootstarter.beans.Docs;
import com.ib.springbootstarter.beans.History;
import com.ib.springbootstarter.beans.Location;

@Service
public class Services {
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	@Autowired
	NewsAPIController newsAPIController;
	
	public List<Disaster> getDisaster(){
		//getConnection();
		List<Disaster> disasters = jdbcTemplate.query("SELECT * FROM disaster",
		(resultSet, rowNum) -> new Disaster(resultSet.getInt("id"),resultSet.getString("name")));
		return disasters;
	}
	public List<Location> getLocation(){
		//getConnection();
		List<Location> locations = jdbcTemplate.query("SELECT * FROM location",
		(resultSet, rowNum) -> new Location(resultSet.getInt("id"),
											resultSet.getString("city"),
											resultSet.getString("state"),
											resultSet.getString("country"),
											resultSet.getString("longitude"),
											resultSet.getString("latitude")));
		locations.forEach(System.out::println);
		return locations;
		
	}
	public String loadHistoryTable(){
		List<Disaster> disasters=getDisaster();
		List<Location> locations=getLocation();
		List<History> histories = new ArrayList<History>();
		for (Disaster disaster : disasters) {
			
		
		for (Location location : locations) {
			List<Docs> docs=newsAPIController.getNews(disaster.getName(),location.getCity()).getResponse().getDocs();
			for (Docs doc : docs) {
				History history = new History
						("date", disaster.getName(), location.getCity(), 
								location.getState(), location.getCountry(), location.getLongitude(), 
								location.getLatitude(), doc.getHeadline().getPrint_headline(),doc.getWeb_url());
				histories.add(history);
			}
			
		}
		}		
		return "";
	}
}
