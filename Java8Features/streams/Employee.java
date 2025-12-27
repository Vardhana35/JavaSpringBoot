package com.tcs.Java8Features.streams;

public class Employee{
	private int eno;
	private String ename;
	private int sal;
	private String dept;
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(int eno, String ename, int sal, String dept) {
		this(eno,ename,sal);
		this.dept = dept;
	}

	public Employee(int eno, String ename,int sal) {
		this.eno = eno;
		this.ename = ename;
		this.sal=sal;
	}
	
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
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
	public String toString() {
		return eno+" "+ename+" "+sal;
	}

	
}
