package com.tcs.Java8Features.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDuplicateEx {

	public static void main(String[] args) {
		
		List<Employee> l=Util.getEmployees();
		
		List<String> names=l.stream().map(x->x.getEname()).distinct().collect(Collectors.toList());
		System.out.println("size: "+names.size());
		
		System.out.println("names in ascending order: ");
		l.stream().map(x->x.getEname()).sorted().forEach(System.out::println);
		
		System.out.println("names in descending order: ");
		l.stream().map(x->x.getEname()).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//other way to sort in descending order
		System.out.println("other way to sort in descending order:");
		l.stream().map(x->x.getEname()).sorted((x,y)->y.compareTo(x)).forEach(System.out::println);
		
	}
}
