package com.tcs.Handson.Collections1d;

public class Employee implements Comparable<Employee>{
	private int eno;
	private String ename;
	
	public Employee(int eno, String ename) {
		this.eno = eno;
		this.ename = ename;
	}
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public int compareTo(Employee o) {
		int cmp=this.getEname().compareToIgnoreCase(o.getEname());
		if (cmp!=0)
			return cmp;
		return 0;
	}

	
}
