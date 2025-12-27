package com.example.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.example.dao")
@PropertySource("myres.properties")
public class Config {

	@Autowired
	private Resource res;
	
	@Bean	
	public DataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		
		/*ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("Root123$");
		return ds;*/
		
		//other way of injecting properties using property file:myres.properties
		
		ds.setUrl(res.getUrl());
		ds.setUsername(res.getUsername());
		ds.setPassword(res.getPassword());
		return ds;
	
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getProperties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
