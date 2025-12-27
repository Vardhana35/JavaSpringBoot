package com.tcs.Handson.Collections1d;
import java.util.*;
import java.util.List;

public class Ex1 {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(3);
		int maxdiff=Integer.MIN_VALUE;
		int maxIndex=0;
		
		for(int i=0;i<l.size()-1;i++) {
			if (l.get(i)-l.get(i+1)>maxdiff) {
				maxdiff=l.get(i)-l.get(i+1);
				maxIndex=i;
			}
			
		}
		System.out.println("Max index of max diff ele: "+maxIndex);
		
		
	}
}
