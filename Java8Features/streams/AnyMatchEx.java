package com.tcs.Java8Features.streams;

import java.util.*;

public class AnyMatchEx {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(10,20,30,1,5,3,12);
		
		//anyMatch allMatch  noneMatch forEach collect min max --terminal methods
		boolean res=l.stream().anyMatch(x->x%2!=0);
		System.out.println("using anyMatch: "+res);
		
		boolean res1=l.stream().allMatch(x->x%2==0);
		System.out.println("using allMatch: "+res1);
		
		boolean res2=l.stream().noneMatch(x->x%7==0);
		System.out.println("using noneMatch: "+res2);
		
		int first=l.stream().findFirst().get();
		System.out.println("first value: "+first);
		
		Integer min=l.stream().min((x,y)->x.compareTo(y)).get();
		System.out.println("min value: "+min);
		
		Integer max=l.stream().max((x,y)->x.compareTo(y)).get();
		System.out.println("max value: "+max);
		
		int sum=l.stream().reduce((x, y)->x+y).get();
		System.out.println("sum: "+sum);
	}
}
