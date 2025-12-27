package com.tcs.Handson.Collections1d;

import java.util.*;

public class Ex2 {

	public static void main(String[] args) {
		List<Integer> l1=new ArrayList<>(Arrays.asList(12,1,32,3));
		List<Integer> l2=new ArrayList<>(Arrays.asList(0,12,2,23));
		List<Integer> l3=new ArrayList<>(l1.size());
		
		if (l1.size()==l2.size()) {
			for(int i=0;i<l1.size();i++) {
				if (i%2!=0) {
					l3.add(l1.get(i));
				}
				else {
					l3.add(l2.get(i));
				}
			}
		
		}
		System.out.println(l3);
	}
}
