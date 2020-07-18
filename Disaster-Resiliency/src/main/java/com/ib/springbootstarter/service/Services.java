package com.ib.springbootstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ib.springbootstarter.beans.Disaster;

@Service
public class Services {
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	
	public void getDisaster(){
		//getConnection();
		List<Disaster> disasters = jdbcTemplate.query("SELECT * FROM disaster",
		(resultSet, rowNum) -> new Disaster(resultSet.getInt("id"),resultSet.getString("name")));
		disasters.forEach(System.out::println);
	}
	
}
