package com.tcs.Handson.Strings;

public class Ex3 {

	public static void main(String[] args) {
		String[] s= {"Tn_Chennai","Karnataka_Bangalore"};

		for(int i=0;i<s.length;i++) {
			String[] s1=s[i].split("_");
			if(s1[0].equalsIgnoreCase("karnataka")) {
				System.out.println(s1[1]);
			}
		}
	}
}
