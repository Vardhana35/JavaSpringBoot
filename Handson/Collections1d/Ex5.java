package com.tcs.Handson.Collections1d;

//import java.util.Arrays;
import java.util.*;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> l1=new ArrayList<>(Arrays.asList(1,2,3,4));
		List<Integer> l2=new ArrayList<>(Arrays.asList(3,4,5,6));
		int cnt=0;
		for(int i=0;i<l1.size();i++) {
			for(int j=0;j<l2.size();j++) {
				if (l1.get(i).equals(l2.get(j))) {
					cnt++;
				}
			}
		}
		System.out.println("No of common ele: "+cnt*2);
		
	}

}
