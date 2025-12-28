package com.tcs.spring.jpa.beans;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "empno"
	)
@Entity
@Table(name = "pf_bank_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PfBankDetails {

	@Id
	@Column(name = "empno")
	private int empno;

	@Column(name = "pfno", nullable = false, length = 50)
	private String pfno;

	@Column(name = "acc_num", nullable = false)
	private int accNum;

	@Column(name = "details", length = 255)
	private String details;
	
	@OneToOne
	@JoinColumn(name="empno",referencedColumnName = "empno")
	private Employee emp;
	
	

}
