package com.tcs.spring.jpa.beans;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	private String deptno;
	@Column
	private String dname;
	@Column
	private String loc;
	@Column
	private int capaicty;

	//one-many mapping
	
	@OneToMany
	@JoinColumn(name = "deptno")
	List<Employee> emp;
}
