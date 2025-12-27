package com.tcs.Handson.Collections1d;

import java.util.*;

public class Ex4 {
	
	static boolean isPrime(int n) {
		if (n<=1) 
			return false;
		
		for(int i=2;i<n/2;i++) {
			if (n%i==0) 
				return false;		
		}
		return true;
	}

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
			
		int sum=0;
		int avcnt=0;
		
		for(int i=0;i<l.size();i++) {
			if (isPrime(i)) {
				sum+=l.get(i);
				avcnt++;
			}
		}
		
		System.out.println("average: "+((float)sum/avcnt));
	}
}
