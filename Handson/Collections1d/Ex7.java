package com.tcs.Handson.Collections1d;

import java.util.*;

public class Ex7 {

	public static void main(String[] args) {
		
		TreeSet<Integer> ss=new TreeSet<>(new AbsRef());
		
		int[] n= {1,-1,10,-10,-11,45,56};
		for(int i=0;i<n.length;i++) {
			ss.add(n[i]);
			}
		
		System.out.println(ss);

	}

}
