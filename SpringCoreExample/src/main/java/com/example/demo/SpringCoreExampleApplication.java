package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("Sample.xml");//here itself object is created implicitly for the bean class(Resource)
		
		//by default bean object is single-ton i.e object is created only once
		//other way of injecting resource class by spring container
		//Resource r1=(Resource)context.getBean("s1");
		
		Resource r1=context.getBean(Resource.class);
		System.out.println(r1.getResourceName()+" "+r1.getResourcePort());
		
		
		Resource2 r2=context.getBean(Resource2.class);
		System.out.println(r2.getResourceName()+" "+r2.getResourcePort());
		
		((ClassPathXmlApplicationContext)context).close();//to detsroy or close the bean object
	}

}