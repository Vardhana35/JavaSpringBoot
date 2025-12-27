package com.tcs.Java8Features.FuncInterf;

public class Main {

	public static void main(String[] args) {
		
		Message m1=()->{
			System.out.println("Good Morning");
		};
		m1.giveMessage();
		
		m1=()->{
			System.out.println("Good Afternoon");
		};
		m1.giveMessage();
		
		m1.method1();
		
		Message.method2();
	}
}
