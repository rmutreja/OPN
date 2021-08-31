package com.opn.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.validation.constraints.NotNull;

/*
 * CustomerEntity The customer program implements an application such that the
 * data of the customer is sent to the database.
 */	
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Customer {

	/**
	 * This is a local variable: defines the unique Id for the customer
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@NotNull(message= "Customer Id can't be null")
	@Size(min=1,max=10, message= "Please provide a valid customerId")
	private Integer customerId;
	
	/*
	 * This is a local variable:{@link #name} defines the customer name 
	 */
	@Column
	@NotEmpty(message= "please provide customer name")
	@Size(min=2,max=20, message= "Please provide a valid customer Name")
	private String customerName;
	
	/*
	 * This is a local variable:{@link #email} defines the customer email 
	 */
	@Column(unique= true)
	@NotEmpty(message= "please provide customer email")
	private String customerEmail;
	
	/*
	 *  This is a local variable:{@link #user name} defines the user name of the customer. 
	 */
	@Column
	@NotEmpty(message= "please provide user name")
	private String userName;
	
	/*
	 *  This is a local variable:{@link #password} defines the password of the customer
	 */
	@Column
	@NotEmpty(message= "please provide password")
	@Size(min=8,max=50, message= "Please provide a valid password")
	private String password;
	
	@Embedded	
	private Address address;
	
	@JsonManagedReference(value = "customer")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private List<OrderBooking> order;

	
	}
	


