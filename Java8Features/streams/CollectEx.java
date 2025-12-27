package com.tcs.Java8Features.streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectEx {

	public static void main(String[] args) {
		
		List<Employee> l=Util.getEmployees();
		
		//retriving enames as list using collect
		List<String> names=l.stream().map(x->x.getEname()).collect(Collectors.toList());
		System.out.println(names + "  "+ "size: "+ names.size());
		
		//extract enames into list whose eno is more than 103
		List<String> names1=l.stream().filter(x->x.getEno()>103).map(x->x.getEname()).collect(Collectors.toList());
		System.out.println(names1 + "  "+ "size: "+ names1.size());
	}
}
