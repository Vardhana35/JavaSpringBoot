package com.tcs.Java8Features.FuncInterf;

@FunctionalInterface
public interface Message {
 
	//should have only one abstract method
	void giveMessage();
	
	//can have one or more default methods
	default void method1() {
		System.out.println("this is a default method1 in functional interface");
	}
	//can have one or more static methods
	static void method2(){
		System.out.println("this is a static method2 in functional interface");
	}
}
