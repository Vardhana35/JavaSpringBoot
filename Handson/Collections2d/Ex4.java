package com.tcs.Handson.Collections2d;

import java.util.*;

public class Ex4 {

	public static void main(String[] args) {
		
		Map<Integer,String> m1=new HashMap<>();
		m1.put(1,"Analyst");
		m1.put(2,"Manager");
		
		Map<Integer,Integer> m2=new HashMap<>();
		m2.put(1,12000);
		m2.put(2,5000);
		
		Map<Integer,Integer> m3=new HashMap<>();
		
		for(Map.Entry<Integer, String> m:m1.entrySet()) {
			if (m.getValue().equals("Manager")) {
				m3.put(m.getKey(), m2.get(m.getKey())+5000);
			}
		}
		
		
		//other logic
		for(Integer i:m1.keySet()) {
			if (m1.get(i).equalsIgnoreCase("manager")) {
				m3.put(i, m2.get(i)+5000);
			}
		}
		
		System.out.println(m3);
		
		
	}
}
