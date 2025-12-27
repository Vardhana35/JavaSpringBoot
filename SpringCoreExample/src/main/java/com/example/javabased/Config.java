package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class Config {

	@Bean(name="r1")
	@Primary
	public Resource getResource() {
		Resource r1=new Resource();
		r1.setResourceName("Oracle");
		r1.setResourcePort(8080);
		return r1;
	}
	
	@Bean(name="r2")
	public Resource getResource2() {
		Resource r1=new Resource();
		r1.setResourceName("Oracle");
		r1.setResourcePort(8080);
		return r1;
	}
	
	@Bean
	public Resource getResource3() {
		Resource r1=new Resource();
		r1.setResourceName("Oracle");
		r1.setResourcePort(8080);
		return r1;
	}
}
