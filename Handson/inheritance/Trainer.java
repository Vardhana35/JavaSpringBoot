package com.tcs.Handson.inheritance;

public class Trainer extends Person{
	private String subject;
	private int salary;
	private String type;
	
	public Trainer(String fname, String lname, String subject, int salary, String type) {
		super(fname,lname);
		this.subject = subject;
		this.salary = salary;
		this.type = type;
	}
	
	void display() {
		super.display();
		System.out.println(subject+" "+salary+" "+type);
	}
	
	

}
