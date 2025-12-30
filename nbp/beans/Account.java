package com.tcs.nbp.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "accNum")
@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@Min(10000)
	@Max(1000000)
	private Integer accNum;

	@Size(min = 5, max = 20, message = "accName must be between 5 and 20 characters")
	@Column
	private String accName;

	@Positive(message = "balance must be positive")
	@Column
	private Double balance;

	@Size(min = 10, message = "branchId must be at least 10 letters")
	@Column
	private String branchId;

	@Column
	private String area;

	@Email(message = "email must be a valid email")
	@Column
	private String email;

	@OneToMany
	@JoinColumn(name = "accNum")
	private List<TransactionHistory> transactions;

}
