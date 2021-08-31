package com.opn.in.service;

import java.util.List;
import com.opn.in.entity.Customer;
 
public interface ICustomerService
 {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer, Integer custId);
	public void deletCustomer(Integer custrId);
	public Customer viewCustomer(Integer custId);
	public List<Customer> viewAllCustomers();
	boolean validateCustomer(String userName, String password);
	
}
