package com.tcs.Handson.Collections2d;

public class Employee implements Comparable<Employee>{

	private int empid;
	private String ename;
	private int sal;
	
	public Employee(String ename, int sal) {
		this.ename = ename;
		this.sal = sal;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public String toString() {
		return empid+"  "+ename+"  "+sal;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getEmpid()-o.getEmpid();
		//return Integer.compare(this.getEmpid(),o.getEmpid());
	}
	
	
	
	
}
