package com.tcs.Java8Features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkipLimitEx {

	public static void main(String[] args) {
		
		List<Integer> l=Arrays.asList(10,20,30,40,50,60,70,70,80);
		
		System.out.println("using limit: ");
		l.stream().limit(4).forEach(System.out::println);
		
		System.out.println("using skip: ");
		l.stream().skip(4).forEach(System.out::println);
		
		//to find the 3rd max value
		System.out.println("third max value: ");
		l.stream().sorted(Comparator.reverseOrder()).distinct().skip(2).limit(1).forEach(System.out::println);;
	}
}
