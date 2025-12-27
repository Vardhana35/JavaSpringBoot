package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Resource2  implements InitializingBean,DisposableBean{

	private String resourceName;
	private int resourcePort;
	
	
	public Resource2(String resourceName, int resourcePort) {
		super();
		this.resourceName = resourceName;
		this.resourcePort = resourcePort;
	}

	public String getResourceName() {
		return resourceName;
	}
	
	public int getResourcePort() {
		return resourcePort;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init method");
	}

}
