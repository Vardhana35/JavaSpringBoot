package com.tcs.Handson.assesment;

public class Operator {

	private int a;
	private int b;
	private int c;
	private int d;

	public Operator(int a, int b) {
		this.a = a;
		this.b = b;
	}

	void sum() {
		c = a + b;
		System.out.println("sum of " + a + ", " + b + ": " + c);
	}

	void mul() {
		d = a * b;
		System.out.println("product of " + a + ", " + b + ": " + d);
	}

	void setValues(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
