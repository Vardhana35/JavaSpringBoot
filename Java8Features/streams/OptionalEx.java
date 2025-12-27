package com.tcs.Java8Features.streams;

import java.util.Optional;

public class OptionalEx {

	public static void main(String[] args) {
		
		//Optional<Employee> op=Optional.of(object);
		
		Optional<String> op=Optional.empty();
		if(op.isPresent()) {
			System.out.println("object op is there");
		}else {
			System.out.println("object op is not there");
		}
		
		Employee emp=new Employee(0, null, 0);
		Optional<Employee> ope=Optional.of(emp);
		if(ope.isPresent()) {
			System.out.println("object emp is there");
		}else {
			System.out.println("object emp is not there");
		}
		
		//second way
		ope.ifPresentOrElse(x->System.out.println("emp is there"), ()->System.out.println("emp is not there"));
		
		Employee emp2=null;
		Optional<Employee> ope2=Optional.ofNullable(emp2);
		if(ope2.isPresent()) {
			System.out.println("object emp2 is there");
		}else {
			System.out.println("object emp2 is not there");
		}
		
		
	}
}
