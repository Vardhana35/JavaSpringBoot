package com.example.Componentproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		
		Resource r1=context.getBean(Resource.class);
		System.out.println(r1.getResourceName()+" "+r1.getResourcePort());
		
		//accessing using @Autowired
		
		System.out.println("using @Autowired to inject bean properties");
		Resource2 r2=context.getBean(Resource2.class);
		r2.display();
		
	}
}
