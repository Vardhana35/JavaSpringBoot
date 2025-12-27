package com.tcs.Java8Features.methodreference;

public class OperatorEx {
	public static void main(String[] args) {
		
		Operator ope=(a,b)->{
			int c=a-b;
			System.out.println("diff is: "+c);
		};
		
		ope.performOperation(10, 20);
		ope=MathsOperations::new; // reference to parameterized constructor
		ope.performOperation(10, 20);
		
		//reference of non-static methods to interface ope
		MathsOperations mo=new MathsOperations();
		ope=mo::multiplication;
		ope.performOperation(10, 20);
		
		ope=mo::addition;
		ope.performOperation(10, 20);
		
		//reference of static method to interface ope
		ope=MathsOperations::div;
		ope.performOperation(20, 10);
		
		
	}
}
