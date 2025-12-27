package com.tcs.Java8Features.streams;

import java.util.Arrays;
import java.util.List;

public class CountEx {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(10,2,1,5,3,-1,4);
		
		//count even nos
		long count=l.stream().filter(x->x<0).count();
		System.out.println("count: "+count);
		
		System.out.println("--------");
		l.stream().filter(x->x%2==0).map(x->x*3).forEach(System.out::println);
	}
}
