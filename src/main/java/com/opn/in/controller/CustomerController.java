package com.opn.in.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opn.in.entity.Customer;
import com.opn.in.exception.CustomerException;
import com.opn.in.exception.CustomerNotFoundException;
import com.opn.in.service.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/customer")
@Api(description="this is Customer Controller to perform operations")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//HAS-A Relationship
	@Autowired
	private CustomerServiceImpl cservice; 
	
	/*{
  		"customerEmail": "vaityagi@gmail.com",
  		"customerId": 1,
  		"customerName": "Vaishali",
  		"password": "tyagi",
  		"userName": "Vaityagi"
	 }
	 {
	 	"addressId": 1,
    	"city": "Meerut",
    	"colony": "ShriNagar",
    	"houseNo": "403",
    	"pincode": 245356,
    	"state": "Up"
    }	 
	 * http://localhost:8080/customer/addCustomer
	 * This url is responsible for adding a customer
	 * HTTP Method POST is required
	 */
    @ApiOperation(value="This is addCustomer method() to add customer object to table")
	@PostMapping(value="/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) throws CustomerException{
	 try{
		 logger.info("Called POST mapping addCustomer() method");
	 
	
	 Customer customer1= cservice.addCustomer(customer);
	 ResponseEntity<String> entity = new ResponseEntity<String>("Customer with id " + customer1.getCustomerId()+
			 " is created", HttpStatus.CREATED);
	 return entity;
	 } catch (Exception e) {
			logger.error("Record NOT Added  : " + customer);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			
		}

	}
 
	/*
	 * http://localhost:8080/customer/updateCustomer/2
	 * This url update the customer details in customer service
	 * HTTP Method PUT is required
	 */
    @ApiOperation(value="This is updateCustomer method() to update customer to table")
	@PutMapping(value = "/updateCustomer/{custId}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable Integer custId)
			throws CustomerNotFoundException {
    	try{
    	logger.info("Called PUT mapping updateCustomer() method");
		Customer customer1 = cservice.updateCustomer(customer, custId);
		ResponseEntity<String> entity = new ResponseEntity<String>(
				"Customer with id " + customer1.getCustomerId() + " updated successfully", HttpStatus.OK);
		return entity;
    } catch (Exception e) {
		logger.error("Record NOT Found  : " + customer);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		
	}
	}
	
	/*
	 * http://localhost:8080/customer/deletCustomer/2
	 * This url delete the customer details in customer service
	 * HTTP Method DELETE is required
	 */
    @ApiOperation(value="This is deletCustomer method() to delete customer from the table")
	@DeleteMapping(value = "/deletCustomer/{custId}")
	public ResponseEntity<String>deletCustomer(@PathVariable Integer custId) throws CustomerNotFoundException {
    	try{
    	logger.info("Called DELETE mapping removeCustomer() method");
		Customer customer1= cservice.viewCustomer(custId);
		cservice.deletCustomer(customer1.getCustomerId());
		ResponseEntity<String> entity = new ResponseEntity<String>(
			"Customer with id " + customer1.getCustomerId() + " deleted successfully", HttpStatus.OK);
	
		return entity;
    } catch (Exception e) {
		logger.error("Record NOT Deleted with ID  : " + custId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		
	}
		
	}

	/*
	 * http://localhost:8080/customer/viewCustomer/2
	 * This url shows the customer details by Id in customer service
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is viewCustomer method() to view customer by id in the table")
	@GetMapping(value = "/viewCustomer/{custId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable Integer custId) throws CustomerNotFoundException {
    	try{
    	logger.info("Called GET mapping viewCustomer() method");
		Customer customer1 = cservice.viewCustomer(custId);
		ResponseEntity<Customer> entity = new ResponseEntity<Customer>(customer1, HttpStatus.OK);
		return entity;
    } catch (Exception e) {
		logger.error("Record NOT Found with ID  : " + custId);
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		
	}
	}

	/*
	 * http://localhost:8080/customer/viewAllCustomers
	 * This method retrieve all the customer's details from the viewAllCustomer method
	 * in Customer Service
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is viewAllCustomer method() to view all customer by id in the table")
	@GetMapping(value="/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerNotFoundException
	{
    	try{
    	logger.info("Called GET mapping viewAllCustomers() method");
    	List<Customer> allCustomers= cservice.viewAllCustomers();
    	ResponseEntity<List<Customer>> entity = new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
    		return entity;
    	} catch (Exception e) {
		logger.error("Record NOT Found");
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		
    	}
	}
    
    
 
}