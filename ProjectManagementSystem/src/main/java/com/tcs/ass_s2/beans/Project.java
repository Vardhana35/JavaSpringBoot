package com.tcs.ass_s2.beans;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Project {

	@NotNull
	@Id
	@Length(min=5,max=10,message="provide a valid id")
	private String projectId;
	
	@Column
	@Length(min=5,max=20,message="provide a valid project name")
	private String pName;
	
	@Column
	@Positive
	private Float billPerHr;
	
	@Length(min=10,max=Integer.MAX_VALUE,message="provide a valid client name")
	@Column
	private String clientName;
	
	@Length(min=5,max=20,message="provide a valid country")
	@Column
	private String country;
	
	@Length(min=2,max=Integer.MAX_VALUE,message="provide a valid country code")
	@Column
	private String cntryCode;
	
}
