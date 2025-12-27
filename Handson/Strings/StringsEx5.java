package com.tcs.Handson.Strings;
import java.util.*;

public class StringsEx5 {
	Scanner sc=new Scanner(System.in);
	void maxWord() {
		String s1="Hi how are you I am good";
		String s[]=s1.split(" ");
		String max=" ";
		for(int i=0;i<s.length;i++) {
			if (s[i].length()>max.length()) {
				max=s[i];
			}		
		}
		System.out.println("max word: "+max);
	}
	
	void checkPalindrome() {
		System.out.print("Enter a string:");
		String input1=sc.next();
		StringBuffer sb=new StringBuffer(input1);
		String revstr=sb.reverse().toString();
		if (input1.equals(revstr)) {
			System.out.println(input1+" is a palindrome");
		}
		else {
			System.out.println(input1+" is not a palindrome");
		}
	}
	
	void checkTcsMails() {
		String[] emails={"abc@gmail.com","xyz@tcs.com","pqr@yahoo.com","abc@tcs.com"};
		int cnt=0;
		for(int i=0;i<emails.length;i++) {
			if(emails[i].endsWith("tcs.com")) {
				cnt++;
			}
		}
		System.out.println("count of tcs emails:"+cnt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringsEx5 s3=new StringsEx5();
		
		s3.maxWord();

		s3.checkPalindrome();
		
		s3.checkTcsMails();
		

	}

}
