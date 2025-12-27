package com.example.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		ReadData rd=context.getBean(ReadData.class);
		rd.readData();
		
		System.out.println("----------------");

		rd.readData1();
		
		
		
		
		
		
	    
	}
}
