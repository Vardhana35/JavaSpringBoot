package com.tcs.Java8Features.methodreference;

public class C1 {

	C1(){
		System.out.println("Default constructor");
	}
	
	C1(int a,int b){
		System.out.println(a+" "+b);
	}
		
	void m1() {
		System.out.println("method1 in C1");
	}
	
	int methodC2(int a,int b) {
		int c=a+b;
		System.out.println(a+" + "+b+" : "+c);
		return c;
	}
	
	void methodC1(int a,int b) {
		System.out.println("Method2 in C1");
	}
	
	static void m2() {
		System.out.println("static method in C1");
	}
	
	public static void main(String[] args) {
		C1 obj=new C1();
		
		I1 i1=C1::new; //constructor reference to I1
		i1.method1();
		
		I2 i2=C1::new; //constructor reference to I2
		i2.method2(10, 20);
		
		i1=obj::m1; //m1 in C1 reference to I1
		i1.method1();
		
		i2=obj::methodC1;//methodC1 in C1 reference to I2
		i2.method2(10, 20);
		
		i2=obj::methodC2;//metthodC2 in C1 reference to I2
		i2.method2(10, 20);
		
		
		
	}
}
