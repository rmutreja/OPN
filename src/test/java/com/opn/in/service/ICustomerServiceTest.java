package com.opn.in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.opn.in.entity.Address;
import com.opn.in.entity.Customer;
import com.opn.in.entity.OrderBooking;
import com.opn.in.repository.ICustomerRepository;

@SpringBatchTest
public class ICustomerServiceTest 
 {
	@Autowired
	private ICustomerService cservice;
	@MockBean
	private ICustomerRepository crepository;
	@Test
	public void testAddCustomer() {
		
		Address address =new Address(1,"123","Shrinagar","Meerut","Up",123456);
		OrderBooking o1=OrderBooking.builder().totalCost(100)
				.transactionMode("Online").quantity(20).build();
		OrderBooking o2=OrderBooking.builder().totalCost(44)
				.transactionMode("Cash").quantity(20).build();
		List<OrderBooking> ll=Arrays.asList(o1,o2);
		Customer customer1=  new Customer(1,"Vaishali","vai.tyagi@gmail.com","vaityagi","tyagi",address,ll);
		when(crepository.save(customer1)).thenReturn(customer1);
		assertEquals(customer1.getCustomerId(), cservice.addCustomer(customer1).getCustomerId());
	}
	
	@Test
	public void testUpdateCustomer() {
		Address address= Address.builder().addressId(1).houseNo("123").colony("Shrinagar")
				.city("Meerut").state("Up").pincode(123456).build();
		OrderBooking o1=OrderBooking.builder().totalCost(30)
				.transactionMode("Online").quantity(20).build();
		OrderBooking o2=OrderBooking.builder().totalCost(44)
				.transactionMode("Cash").quantity(20).build();
		List<OrderBooking> ll=Arrays.asList(o1,o2);
		Customer customer1 = new Customer(1,"Purvi","pur.tyagi@gmail.com","purtyagi","tyagi",address,ll);
		when(crepository.save(customer1)).thenReturn(customer1);

		Optional<Customer> actual = Optional.of(cservice.addCustomer(customer1));
		when(crepository.findById(actual.get().getCustomerId())).thenReturn(actual);
	}
	
	@Test
	public void testDeletCustomer()
	{
		cservice.deletCustomer(3);
		crepository.deleteById(3);
	}
	
	@Test
	public void testViewCustomer() {
		Address address= Address.builder().addressId(1).houseNo("123").colony("Shrinagar")
				.city("Meerut").state("Up").pincode(123456).build();
		
		OrderBooking o1=OrderBooking.builder().totalCost(100)
				.transactionMode("Cash").quantity(20).build();
		OrderBooking o2=OrderBooking.builder().totalCost(30)
				.transactionMode("Online").quantity(20).build();
		List<OrderBooking> ll=Arrays.asList(o1,o2);
		Optional<Customer> customer1 = Optional
				.of(new Customer(1,"Vaishali","vai.tyagi@gmail.com","vaityagi","tyagi",address,ll));

		when(crepository.save(customer1.get())).thenReturn(customer1.get());
		when(crepository.findById(customer1.get().getCustomerId())).thenReturn(customer1);

		assertEquals(customer1.get().getCustomerName(), cservice.viewCustomer(1).getCustomerName());
		}
	
		@Test
		public void testViewAllCustomers() {
			List<Customer> allCustomers = new ArrayList<Customer>();

			OrderBooking o1=OrderBooking.builder().totalCost(100)
					.transactionMode("Cash").quantity(20).build();
			OrderBooking o2=OrderBooking.builder().totalCost(30)
					.transactionMode("Online").quantity(20).build();
			List<OrderBooking> ll=Arrays.asList(o1,o2);
			Address address1= Address.builder().addressId(1).houseNo("123")
					.colony("Shrinagar").city("Meerut").state("Up").pincode(123456).build();
			allCustomers.add(new Customer(1,"Vaishali","vai.tyagi@gmail.com","vaityagi","tyagi",address1,ll));
			Address address2= Address.builder().addressId(2).houseNo("124")
					.colony("Shivpuri").city("Hapur").state("Up").pincode(123457).build();
			allCustomers.add(new Customer(2,"Purvi","pur.tyagi@gmail.com","purtyagi","tyagi",address2,ll));
			Address address3= Address.builder().addressId(3).houseNo("125")
					.colony("AvasVikas").city("Delhi").state("Delhi").pincode(123458).build();
			allCustomers.add(new Customer(3,"Rohan","rohan.tyagi@gmail.com","rotyagi","tygai",address3,ll));

			when(crepository.findAll()).thenReturn(allCustomers);

			assertEquals(2, cservice.viewAllCustomers().size());
		}
	}
 