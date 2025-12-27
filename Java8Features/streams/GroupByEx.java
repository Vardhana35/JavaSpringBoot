package com.tcs.Java8Features.streams;

import java.util.*;
import java.util.stream.*;

public class GroupByEx {

	public static void main(String[] args) {
		
		List<Employee> l=Util.getEmployeesByDept();
		
		
		Map<String,List<Employee>> map=l.stream().collect(Collectors.groupingBy(x->x.getDept()));
		map.forEach((x,y)->{
			System.out.println(x+" "+y);
		});
		
		
		
		System.out.println("---------------------------------");
		l.stream().collect(Collectors.groupingBy(x->x.getDept())).
				forEach((x,y)->{
			System.out.println(x+" "+y);
		});
		
	}
}
