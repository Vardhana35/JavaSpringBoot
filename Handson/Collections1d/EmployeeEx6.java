package com.tcs.Handson.Collections1d;

import java.util.Comparator;
import java.util.*;

public class EmployeeEx6 {

	public static void main(String[] args) {

		Employee e1 = new Employee(101, "Hari");
		Employee e2 = new Employee(105, "abc");

		SortedSet<Employee> ss = new TreeSet<>(new EmployeeRefSort());
		ss.add(e1);
		ss.add(e2);
		
		SortedSet<Employee> ss1 = new TreeSet<>();
		ss1.add(e1);
		ss1.add(e2);
		
		System.out.println("Displaying in descending order based on ename: ");
		for(Employee e:ss) {
			System.out.println(e.getEno()+" "+e.getEname());
		}
		
		System.out.println("Displaying in ascending order based on ename: ");
		for(Employee e:ss1) {
			System.out.println(e.getEno()+" "+e.getEname());
		}

	}

}
