package com.tcs.Handson.Abstraction;

abstract public class Employee {

	private int empno;
	private String ename;
	
	abstract void jobs();
	abstract void timings();
	void noticePeriod() {
		System.out.println("Notice Period is 2 months.");
	}
	
}
