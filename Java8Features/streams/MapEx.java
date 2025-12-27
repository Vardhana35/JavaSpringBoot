package com.tcs.Java8Features.streams;

import java.util.List;

public class MapEx {

	public static void main(String[] args) {
		
		List<Employee> l=Util.getEmployees();
		
		//displaying eno using map
		System.out.println("displaying eno");
		l.stream().map(x->x.getEno()).forEach(x->System.out.println(x));
		
		//displaying eno using method reference to forEach(interface)
		//forEach is a consumer interface
		System.out.println("displaying eno using method reference");
		l.stream().map(x->x.getEno()).forEach(System.out::println);
		
	
		//displaying enames using map
        System.out.println("displaying enames");
        l.stream().map(x->x.getEname()).forEach(x->System.out.println(x));
		
		//displaying sal using map
		System.out.println("displaying sal");
		l.stream().map(x->x.getSal()).forEach(x->System.out.println(x));
		
		//displaying sal using map and sal>15000 using filter
		System.out.println("displaying sal>15000");
		l.stream().map(x->x.getSal()).filter(x->x>15000).forEach(x->System.out.println(x));
		
	}
}
