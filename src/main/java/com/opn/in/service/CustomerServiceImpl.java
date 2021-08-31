package com.opn.in.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opn.in.entity.Customer;
import com.opn.in.exception.CustomerNotFoundException;
import com.opn.in.repository.ICustomerRepository;


@Service
public class CustomerServiceImpl implements ICustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);
	
	@Autowired
	private ICustomerRepository crepository;

	 //This method is used to add customers.
	@Override
	public Customer addCustomer(Customer customer)
	{
		Customer customer1= crepository.save(customer);
		logger.info("Called addCustomer() method of Customer service");
		return customer1;
	}


	@Override
	public Customer updateCustomer(Customer customer ,Integer custId) {
		Optional<Customer> searchCustomer= crepository.findById(custId);
		if(searchCustomer.isPresent()) {
			return crepository.save(customer);
		}
		else {
			throw new CustomerNotFoundException("Customer with given Id:"+custId+"Not Availabel");
		}
	}

	@Override
	public void deletCustomer(Integer custId) throws CustomerNotFoundException  {
		Optional<Customer> searchCustomer= crepository.findById(custId);
		if(searchCustomer.isPresent()) {
			crepository.deleteById(custId);
			}
		else {
			throw new CustomerNotFoundException("Customer with given Id:"+custId+"Not Availabel");
		
		}
		
	}

	// This method is used to fetch a single customer using customerId
	@Override
	public Customer viewCustomer(Integer custId) throws CustomerNotFoundException 
	{
		return crepository.findById(custId).orElseThrow(()->new CustomerNotFoundException("Customer with given Id:"+
	custId+"Not Availabel"));
	}

	// This method is used to return list of all the customers
	@Override
	public List<Customer> viewAllCustomers()
	{
		List<Customer> allcustomers = crepository.findAll();
		return allcustomers;
	}
	
	@Override
	public boolean validateCustomer(String userName, String password) {
		
		Optional<Customer> c=crepository.findByUserName(userName);
		Customer cc=c.get();
		
		if(c.isPresent()) {
			if(cc.getPassword().equals(password))
				return true;
			else
				return false;
			
		}
		else
			return false;

	}

	
}