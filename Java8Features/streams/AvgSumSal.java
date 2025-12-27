package com.tcs.Java8Features.streams;

import java.util.*;
import java.util.stream.Collectors;

public class AvgSumSal {

	public static void main(String[] args) {
		List<Employee> l=Util.getEmployees();
		
		Double avgsal=l.stream().collect(Collectors.averagingInt(x->x.getSal()));
		
		long sumsal=l.stream().collect(Collectors.summingInt(x->x.getSal()));
		
		System.out.println("avg of salaries: "+avgsal);
		System.out.println("sum of salaries: "+sumsal);
	}
}
