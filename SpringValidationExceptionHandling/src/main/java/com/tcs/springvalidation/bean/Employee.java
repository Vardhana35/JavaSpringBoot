package com.tcs.springvalidation.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Employee {

	@NotNull
	@Min(value = 1, message = "give proper empno")
	@Max(value = 25000, message = "empno should be<25000")
	private int empno;

	@NotEmpty
	@Length(min = 5, max = 20, message = "give a valid name")
	private String ename;

	private int sal;

	@Email(message = "give proper email")
	private String email;

	@NotEmpty
	@Length(min = 3, max = 20, message = "give a valid address")
	private String addr;

	@Length(min = 10, max = 14, message = "give valid phone num")
	private String phnno;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhnno() {
		return phnno;
	}

	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}

}
