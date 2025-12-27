package com.example.Componentproperties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Resource2 {

	@Autowired
	private Resource resource;
	
	void display() {
		System.out.println(resource.getResourceName()+" "+resource.getResourcePort());
	}
	
}
