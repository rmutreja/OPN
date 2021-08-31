package com.opn.in.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*OrderBooking: The Order Booking program implements an application such that the 
*data of the order is sent to the database.
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class OrderBooking {
	
	
	/*
	 *This is a local variable:defines the booking order id for OrderBooking
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(min=1,max=10, message= "Please provide a valid orderId")
	private Integer bookingOrderId;
	
	/*
	 *This is a local variable:defines the total cost for OrderBooking
	 */
	@Column
    @NotNull
    //@NotEmpty(message= "please provide Total cost")
	@Size(min=2,max=20, message= "Please provide a valid transaction mode")
	private double totalCost;
	
    
	/*
	 *This is a local variable:defines the date of order for OrderBooking
	 */
	@Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDate orderDate;
	 
	/*
	 *This is a local variable:defines the transaction mode for OrderBooking
	 */
	@Column
    @NotEmpty(message= "please provide transaction mode")
    @Size(min=2,max=20, message= "Please provide a valid transaction mode")
	private String transactionMode;
	
	/*
	 *This is a local variable:defines the quantity for OrderBooking
	 */
	@Column
    //@NotEmpty(message= "please provide customer name")
	@Size(min=2,max=20, message= "Please provide a valid customer Name")
	private Integer quantity;
	
	
	@JsonBackReference(value = "customer")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "order_planter", joinColumns = @JoinColumn(name = "booking_order_id"), inverseJoinColumns = @JoinColumn(name = "planter_id"))
	private List<Planter> planters;
	


}