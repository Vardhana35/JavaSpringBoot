package com.tcs.Handson.Collections2d;

public class Department {

	private int deptid;
	private String dname;
	
	public Department(int deptid, String dname) {
		this.deptid = deptid;
		this.dname = dname;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String toString() {
		return deptid+"  "+dname;
	}
	
	
}
