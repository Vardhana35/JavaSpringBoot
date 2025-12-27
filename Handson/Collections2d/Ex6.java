package com.tcs.Handson.Collections2d;

import java.util.*;

public class Ex6 {

	public static void main(String[] args) {
		
		Employee e1=new Employee("hari",5000);
		Employee e2= new Employee("nandu",15000);
		Employee e3=new Employee("deekshi",50000);
		
		Map<Employee,Department> t=new TreeMap<>();
		
		e1.setEmpid(105);
		e2.setEmpid(102);
		e3.setEmpid(110);
		
		t.put(e1,new Department(1,"IT"));
		t.put(e2,new Department(3,"Test"));
		t.put(e3,new Department(2,"Dev"));
		
		for(Map.Entry<Employee, Department> m:t.entrySet()) {
			System.out.println(m.getKey()+"  "+m.getValue());
		}
		
		
	}
}
