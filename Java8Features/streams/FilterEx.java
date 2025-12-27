package com.tcs.Java8Features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterEx {

	public static void main(String[] args) {
		
		List<Integer> l=new ArrayList<>(Arrays.asList(10,21,30,41,50));
		//without using streams
		for(Integer i:l) {
			if (i%10==0) {
				System.out.println(i+" ");
			}
		}
		//using streams
		System.out.println("--------------");
	
		l=Arrays.asList(12,4,16,18,11);
		
		//step by step usage of filter in streamAPI 
		Stream<Integer> s1=l.stream(); //converting list object into stream object
		Stream<Integer> s2=s1.filter(x->(x>10));
		Stream<Integer> s3=s2.filter(x->(x%3==0));
		s3.forEach(x->{
			System.out.print(x+"\n");
		});
		
		//one line usage
		l.stream().filter(x->(x>10)).filter(x->(x%3==0)).forEach(x->{
			System.out.print(x+" ");
		});
	}
}
