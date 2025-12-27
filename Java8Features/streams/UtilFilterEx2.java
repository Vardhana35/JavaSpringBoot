package com.tcs.Java8Features.streams;

import java.util.List;

public class UtilFilterEx2 {

	public static void main(String[] args) {
		
		//forEach method from stream
		List<Employee> l=Util.getEmployees();
		
		//displaying values whose sal>5000 using filter as intermediate operation and forEach as terminal op using streamAPI
		l.stream().filter(x->x.getSal()>5000).forEach(x->System.out.println(x));
		
	}
}
