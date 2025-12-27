package com.tcs.Handson.constructors;

public class ExEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp emp1=new Emp();
		emp1.displayDetails();
		Emp emp2=new Emp();
		emp2.displayDetails();
		
		Emp emp3=new Emp(101,"nandu",60000,"permanent");
		emp3.displayDetails();
		Emp emp4=new Emp(105,"hari",85000,"permanent");
		emp4.displayDetails();
	}

}
