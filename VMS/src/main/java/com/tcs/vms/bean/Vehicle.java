package com.tcs.vms.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="vehicle")
public class Vehicle {

	@Id
	@NotNull
	@Length(min=5,max=10,message="provide valid vehicleId")
	private String vehicleId;
	
	@Column
	@Length(min=5,max=20,message="provide valid vehicle model")
	private String vehicleModel;
	
	@Positive
	@Column
	private Float seatPerCost;
	
	@Length(min=10,max=Integer.MAX_VALUE,message="provide a proper ownerName")
	@Column
	private String ownerName;
	
	@Length(min=10,max=15,message="provide a valid phoneNUmber")
	@Column
	private String phoneNumber;
}
