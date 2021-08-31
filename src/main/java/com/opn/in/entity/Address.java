package com.opn.in.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * CustomerEntity The customer program implements an application such that the
 * data of the customer is sent to the database.
 */	
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Embeddable
public class Address {
	
	/**		
	 * This is a local variable: defines the unique Id for the address of the customer
	 */
	private Integer addressId;
	
	/**
	 * This is a local variable:{@link #house no} defines the house number
	 */
	@Column
	@NotEmpty(message= "please provide house no")
	private String houseNo;
		
	/**
	 * This is a local variable:{@link #colony} defines the colony
	 */
	@Column
	@NotEmpty(message= "please provide colony")
	private String colony;
	
	/**
	 * This is a local variable:{@link #city} defines the city
	 */
	@Column
	@NotEmpty(message= "please provide city")
	private String city;
	
	/**
	 * This is a local variable:{@link #state} defines the state
	 */
	@Column
	@NotEmpty(message= "please provide state")
	private String state;
	
	/**
	 * This is a local variable:{@link #pin code} defines the pin code 
	 */
	@Column
	@NotNull
	//@NotEmpty(message= "please provide pincode")
	private Integer pincode;
	
	}



