package com.tcs.Handson.Collections2d;

import java.util.*;

public class Ex5 {
 
	public static void main(String[] args) {
		Map<Integer,Integer> m1=new HashMap<>();
		m1.put(1, 4);
		m1.put(2,7);
		m1.put(3, 8);
		m1.put(4, 6);
		
		int sum=0;
		int cnt=0;
		
		for(Integer i:m1.keySet()) {
			if (i%2!=0) {
				sum+=m1.get(i);
				cnt++;
			}
		}
		
		System.out.println("Average of odd key values: "+(sum/cnt));
	}
}
