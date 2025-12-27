package com.tcs.Java8Features.methodreference;

public class MathsOperations {

	public MathsOperations() {
		
	}
	
	MathsOperations(int a,int b){
		System.out.println(a+" "+b);
	}
	
	void addition(int a,int b) {
		int c=a+b;
		System.out.println("sum is: "+c);
	}
	
	void multiplication(int a,int b) {
		System.out.println("product: "+a*b);
	}
	
	static void div(int a,int b) {
		System.out.println("div is: "+a/b);
	}
}
