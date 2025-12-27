package com.example.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		//Resource r1=context.getBean(Resource.class);
		//System.out.println(r1.getResourceName()+" "+r1.getResourcePort());
		
		Resource r1=(Resource)context.getBean("r1");
		
		Resource r2=(Resource)context.getBean("r2");
		
		Resource r3=context.getBean(Resource.class);//here we will get exception if  do not specify @Primary
		//@Primary tells it is default bean to spring container
		
		System.out.println(r1.getResourceName()+" "+r2.getResourcePort());
		
		
		//((AnnotationConfigApplicationContext)(context)).close();
		
	}
}
