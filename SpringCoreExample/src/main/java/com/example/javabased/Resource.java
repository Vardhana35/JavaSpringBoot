package com.example.javabased;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Resource {

	private String resourceName;
	private int resourcePort;
	
	Resource(){
		System.out.println("object created for bean class");
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public int getResourcePort() {
		return resourcePort;
	}
	public void setResourcePort(int resourcePort) {
		this.resourcePort = resourcePort;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method in resource class");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method in resource class");
	}
}
