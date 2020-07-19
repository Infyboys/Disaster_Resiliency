package com.ib.springbootstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ib.springbootstarter.beans.Disaster;
import com.ib.springbootstarter.beans.History;

@Service
public class Services {
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	
	public List<Disaster> getDisaster(){
		//getConnection();
		List<Disaster> disasters = jdbcTemplate.query("SELECT * FROM disaster",
		(resultSet, rowNum) -> new Disaster(resultSet.getInt("id"),resultSet.getString("name")));
		//disasters.forEach(System.out::println);
		return disasters;
	}
	
	public List<History> getHistory(String disaster, String startDate, String endDate){
		//getConnection();
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
		(resultSet, rowNum) -> new History(resultSet.getString("date"), resultSet.getString("disaster"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("longitude"), resultSet.getString("latitude"), resultSet.getString("keyPoints"),resultSet.getString("articleLink")));

		return historyRecord;
	}
	
}
