package com.tcs.Handson.Collections2d;

import java.util.*;

public class Ex3 {
	
	public static void main(String[] args) {
		
		Map<Integer,String> m=new HashMap<>();
		m.put(12, "hari");
		m.put(13,"krish");
		m.put(18, "mani");
		
		Integer k=0;
		for(Integer i:m.keySet()) {
			if (i>k) {
				k=i;
			}
		}
		System.out.println("value of  largest key: "+m.get(k));
	}
}
