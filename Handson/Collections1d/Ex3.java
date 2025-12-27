package com.tcs.Handson.Collections1d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		
		List<Integer> l1=new ArrayList<>(Arrays.asList(1,2,3,4,100,200,600));
		List<Integer> l2=new ArrayList<>(Arrays.asList(3,4,5,6));
		
		Integer sum=0;
		for(int i=0;i<l1.size();i++) {
			for(int j=0;j<l2.size();j++) {
				if (l1.get(i).equals(l2.get(j))) {
					sum+=l1.get(i);
				}
			}
		}
		
		/*for(int i=0;i<l1.size();i++) {
			if (l2.contains(l1.get(i))) {
				sum+=l1.get(i);
			}
		}*/
		System.out.println("Sum of common ele: "+sum);
	}
}
