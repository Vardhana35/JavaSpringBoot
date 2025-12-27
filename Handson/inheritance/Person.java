package com.tcs.Handson.inheritance;

public class Person {

	private String fname;
	private String lname;
	
	/*Person(){
		System.out.println("Default of Person");
	}*/
	
	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	void display() {
		System.out.println(fname+" "+lname);
	}
	
	
}
