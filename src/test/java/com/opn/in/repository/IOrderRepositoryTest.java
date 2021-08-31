package com.opn.in.repository;

import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
//import org.hibernate.annotations.common.util.impl.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.opn.in.entity.OrderBooking;
//import com.opn.in.entity.Planter;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@Log4j2
public class IOrderRepositoryTest {
	
	@Autowired
	private IOrderRepository orepo;
	
	@Test
	public void testAddOrder()
	{
		//Planter p1=Planter.builder().build();
		OrderBooking o2=OrderBooking.builder().bookingOrderId(123).transactionMode("Cash").quantity(5).totalCost(1850).build();
		
		OrderBooking addOrder=orepo.save(o2);
	    System.out.println("Order Added :" +addOrder);
	    log.info("Added Order : {}",addOrder);
	    Assertions.assertThat(addOrder).isNotNull();
	}
	
	@Test	
	public void testUpdateOrder()
	{
		//Planter p1=Planter.builder().build();
		OrderBooking o2=OrderBooking.builder().bookingOrderId(124).transactionMode("Card").quantity(3).totalCost(1050).build();
		
		OrderBooking updatedorder=orepo.save(o2);
		
		System.out.println("Order Updated : "+updatedorder);
		log.info("Order Plant : {}",updatedorder);
		Assertions.assertThat(updatedorder).isNotNull();
		
	}
	
	@Test
	public void testDeleteOrder(){
		
	    OrderBooking order=new OrderBooking();
		Optional<OrderBooking> deletedOrder=orepo.findById(4);
		System.out.println("Order Deleted : "+deletedOrder);
		orepo.deleteById(4);
		
		
		order=deletedOrder.get();
		Integer i= order.getBookingOrderId();
		Assertions.assertThat(i).isNotNull();
		
	}
	
	@Test
	public void testViewOrder(){
		OrderBooking o1=orepo.findById(123).get();
		System.out.println("Plant by Given ID : "+o1);
		Assertions.assertThat(o1).isNotNull();
		
	}
	
	/*@Test
	public void testViewOrderByCommonName() {
		Orders o=orepo.findByCommonName("");
		System.out.println("Order by Given Common Name : "+o);
		Assertions.assertThat(o).isNotNull();
		
	}*/
	
	@Test
	public void testViewAllOrders()
	{
		List<OrderBooking> allorders=(List<OrderBooking>)orepo.findAll();
		System.out.println("All Order : "+allorders);
		Assertions.assertThat(allorders).isNotNull();
				
	}


//	public Object save(OrderBooking o1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public void deleteById(int i) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public Object findall() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public Object findById(Integer bookingOrderId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	/*@Test
	public void testViewAllOrderss() {
		List<OrderBooking> allordersbytype=(List<OrderBooking>)orepo.findAllByType("");
		System.out.println("All Oders of Same Type : "+allordersbytype);
		Assertions.assertThat(allordersbytype).isNotNull();
		
	}*/

}
