package com.tcs.Handson.Collections1d;

import java.util.Comparator;

public class EmployeeRefSort implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getEname().toLowerCase().compareTo(o1.getEname().toLowerCase());
	}

}
