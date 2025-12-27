package com.example.demo;

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
	
	//init ,destroy are the bean life cycle methods
	void init() {
		System.out.println("init method lifecycle");
	}
	
	void destroy() {
		System.out.println("server is stopped now");
	}
	
	
}
