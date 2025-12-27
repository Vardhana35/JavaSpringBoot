package com.tcs.Java8Features.streams;

import java.util.*;
import java.util.stream.Collectors;

public class ToMapEx {

	public static void main(String[] args) {
		
		List<Employee> l=Util.getEmployees();
		
		//retrieving eno and ename
		Map<Integer,String> maps=l.stream().collect(Collectors.toMap(x->x.getEno(), y->y.getEname()));
		System.out.println(maps);
		
		//retrieving eno and sal
		Map<Integer,Integer> map1=l.stream().collect(Collectors.toMap(x->x.getEno(), y->y.getSal()));
		System.out.println(map1);
		
	}
}
