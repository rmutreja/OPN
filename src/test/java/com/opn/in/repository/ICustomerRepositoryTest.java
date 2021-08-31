package com.opn.in.repository;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.opn.in.entity.Address;
import com.opn.in.entity.Customer;
import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class ICustomerRepositoryTest {
	@Autowired
	private ICustomerRepository crepository;
	@Test
	public void testAddCustomer() {
		
		Address address= Address.builder().houseNo("123").colony("Shrinagar").city("Meerut").state("Up").pincode(123456).build();
		Customer customer1= Customer.builder().customerName("Vaishali").customerEmail("vai.tyagi@gmail.com").userName("VAITYAGI")
				.password("tyagi").address(address).build();
		Customer savedCustomer = crepository.save(customer1);
		log.info("Saved Customer:{}",savedCustomer);
		Assertions.assertThat(savedCustomer).isNotNull();
		 
	
	
	}
	
	//testing method to update department by id
	@Test
	public void testUpdateCustomer() {						
		Customer customer1=new Customer();
		customer1.setCustomerId(3);
		customer1.setCustomerName("asdas");
		customer1.setCustomerEmail("asdas@gmail.com");
		customer1.setUserName("Vaityagi");
		customer1.setPassword("tyagi");;
		
		crepository.save(customer1);
		
		Optional<Customer> updatedCustomer=crepository.findById(3);		
		Assertions.assertThat(updatedCustomer).isNotNull();
	}
}
