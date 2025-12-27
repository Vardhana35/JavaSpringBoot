package com.tcs.Handson.constructors;

public class Emp {
	int eno;
	String ename;
	int sal;
	String type;
	
	Emp(){
		eno=10;
		ename="abc";
		sal=50000;
		type="permanent";
	}

	public Emp(int eno, String ename, int sal, String type) {
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.type = type;
	}
	
	void displayDetails() {
		System.out.println("ename is"+ename+", "+"sal is"+sal);
	}

}
