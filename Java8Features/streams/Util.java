package com.tcs.Java8Features.streams;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Employee> getEmployees(){
		
	List<Employee> l=new ArrayList<>();
	l.add(new Employee(101,"abc",5000));
	l.add(new Employee(102,"def",15000));
	l.add(new Employee(103,"pqr",52000));
	l.add(new Employee(104,"mno",50900));
	l.add(new Employee(105,"xyz",25000));
	return l;
	
	}
	
	public static List<Employee> getEmployeesByDept(){
		
		List<Employee> l=new ArrayList<>();
		l.add(new Employee(101,"abc",5000,"IT"));
		l.add(new Employee(102,"def",15000,"IT"));
		l.add(new Employee(103,"pqr",52000,"HR"));
		l.add(new Employee(104,"mno",50900,"HR"));
		l.add(new Employee(105,"xyz",25000,"Manager"));
		return l;
		
		}
}
