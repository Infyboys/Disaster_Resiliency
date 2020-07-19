package com.ib.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ib.springbootstarter.APIController.NewsAPIController;
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
	
	public List<History> getHistory(String disaster,String startDate,String endDate) {
		String sql = "SELECT date, d.name disaster, city, state, country, longitude, latitude, keyPoints, articleLink "+
				"FROM History h INNER JOIN Disaster d ON h.disasterId = d.id INNER JOIN location l ON h.locationId = l.id";
		
		if(!StringUtils.isEmpty(disaster) || !StringUtils.isEmpty(startDate) || !StringUtils.isEmpty(endDate)) {
			sql += " WHERE ";
			if(!StringUtils.isEmpty(disaster))
				sql += "d.name LIKE '%" + disaster+"%' AND ";
			if(!StringUtils.isEmpty(startDate))
				sql += "h.date >='" + startDate+"' AND ";
			if(!StringUtils.isEmpty(endDate))
				sql += "h.date<='" + endDate+"' AND ";
			sql = sql.substring(0, sql.length()-4);
		}
		
		List<History> historyRecord = jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new History(resultSet.getString("date"),
													resultSet.getString("disaster"),
													resultSet.getString("city"),
													resultSet.getString("state"),
													resultSet.getString("country"),
													resultSet.getString("longitude"),
													resultSet.getString("latitude"),
													resultSet.getString("keyPoints"),
													resultSet.getString("articleLink")));
		
		return historyRecord;
	}
	
	public String loadHistoryTable(){
		
		String clearSql = "DELETE FROM History";
		jdbcTemplate.update(clearSql);
		
		List<Disaster> disasters=getDisaster();
		List<Location> locations=getLocation();
		List<History> histories = new ArrayList<History>();
		for (Disaster disaster : disasters) {
			
		
		for (Location location : locations) {
			List<Docs> docs=newsAPIController.getNews(disaster.getName(),location.getCity()).getResponse().getDocs();
			for (Docs doc : docs) {
				/*History history = new History
						("date", disaster.getName(), location.getCity(), 
								location.getState(), location.getCountry(), location.getLongitude(), 
								location.getLatitude(), doc.getHeadline().getPrint_headline(),doc.getWeb_url());*/
				String sql = "INSERT INTO History (locationId, disasterId, date, keyPoints, articleLink) "
						+ "VALUES (?, ?, ?, ?, ?)";
				jdbcTemplate.update(sql,location.getId(),disaster.getId(),doc.getPub_date().substring(0,10),doc.getHeadline().getMain(),doc.getWeb_url());
				//histories.add(history);
			}
			
		}
		}		
		return "";
	}
	
	public void loadDisaster(){
		//String sql = "INSERT INTO Location (city, state, country, longitude, latitude) VALUES ('Puri','Odisha', 'India', 85.8312, 19.8135 )";
		
		String sql = "INSERT INTO History (locationId, disasterId, date, keyPoints, articleLink) VALUES (2, 2, '2020-06-01', 'Extreme flood', 'samaj.com')";
		
//		String sql = " CREATE TABLE Location(\r\n" + 
//				"	id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,\r\n" + 
//				"	city VARCHAR(45) NOT NULL,\r\n" + 
//				"	state VARCHAR(45) NOT NULL,\r\n" + 
//				"	country VARCHAR(45) NOT NULL,\r\n" + 
//				"	longitude VARCHAR(45) NOT NULL,\r\n" + 
//				"	latitude VARCHAR(45) NOT NULL,\r\n" + 
//				"	PRIMARY KEY (id)\r\n" + 
//				")";
		jdbcTemplate.update(sql);
	}
	
}
