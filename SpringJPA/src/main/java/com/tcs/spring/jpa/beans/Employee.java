package com.tcs.spring.jpa.beans;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "empno"
	)
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@NotNull
	@Min(value = 1, message = "give proper empno")
	@Max(value = 25000, message = "empno should be<25000")
	private int empno;

	@Column
	@NotEmpty
	@Length(min = 5, max = 20, message = "give a valid name")
	private String ename;

	@Column
	private int sal;

	@Column
	@Email(message = "give proper email")
	private String email;

	@Column
	@NotEmpty
	@Length(min = 3, max = 20, message = "give a valid address")
	private String addr;

	@Column
	@Length(min = 10, max = 14, message = "give valid phone num")
	private String phnno;
	
	/*@OneToOne(mappedBy = "emp",cascade=CascadeType.ALL)
	@JoinColumn(name="empno",referencedColumnName = "empno")*/
	
	//one-one mapping
	
	@OneToOne
	@JoinColumn(name="empno")
	private PfBankDetails pfDetails;
	
	
	@Column
	private String deptno;


	public PfBankDetails getPfDetails() {
		return pfDetails;
	}

	public void setPfDetails(PfBankDetails pfDetails) {
		this.pfDetails = pfDetails;
	}

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
