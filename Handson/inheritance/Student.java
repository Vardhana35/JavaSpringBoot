package com.tcs.Handson.inheritance;

public class Student extends Person {

	private int stdno;
	private String stdadd;
	
	public Student(String fname, String lname,int stdno, String stdadd) {
		super(fname,lname);
		this.stdno = stdno;
		this.stdadd = stdadd;
	}
	
	void display() {
		super.display();
		System.out.println(stdno+" "+stdadd);
	}
	
	
}
