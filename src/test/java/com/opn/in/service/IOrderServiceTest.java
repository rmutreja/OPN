package com.opn.in.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.Arrays;
//import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

//import com.example.demo.Service.IOrderService;
//import com.example.demo.controller.OrderBooking;
import com.opn.in.entity.OrderBooking;
import com.opn.in.entity.Planter;
import com.opn.in.repository.IOrderRepository;
//import com.opn.in.repository.IOrderRepositoryTest;

public class IOrderServiceTest<oservice> {
	
	@Autowired
	IOrderService oservice;
	
	@MockBean
	IOrderRepository orepo;
	
	@Test
	public void testAddOrder()
	{
		Planter p1=Planter.builder().build();
		Planter p2=Planter.builder().build();
		List<Planter> pp=Arrays.asList(p1,p2);
		OrderBooking o11=OrderBooking.builder().bookingOrderId(123).transactionMode("Cash").quantity(5).totalCost(1850).planters(pp).build();
		
//		OrderBooking o11= new OrderBooking (124,"Card",3,1050,pp);
		when(orepo.save(o11)).thenReturn(o11);
//		OrderBooking o22=oservice.addOrder(o11);
//		assertEquals(o11,o22);
//		oservice.getBookingOrderId();
		}
	
	@Test
	public void testUpdateOrder() {
		Planter p1=Planter.builder().build();
		Planter p2=Planter.builder().build();
		List<Planter> pp=Arrays.asList(p1,p2);
		OrderBooking order11 = OrderBooking.builder().bookingOrderId(124).transactionMode("Card").quantity(3).totalCost(1850).planters(pp).build();
//		OrderBooking order2 = OrderBooking.builder().bookingOrderId(124).ordertransactionMode("Card").quantity(3).totalCost(1850).planters(pp).build();
//
//		OrderBooking order11 = new OrderBooking(124,1050d,"Cash",3,pp);
		when(orepo.save(order11)).thenReturn(order11);

		Optional<OrderBooking> actual = Optional.of(oservice.addOrder(order11));
		when(orepo.findById(actual.get().getBookingOrderId())).thenReturn(actual);
	}
	
	
	@Test
	public void testDeletCustomer()
	{
		orepo.deleteById(123);
	}
	
	@Test
	public void testViewOrder() {
		Planter p1=Planter.builder().build();
		Planter p2=Planter.builder().build();
		List<Planter> pp=Arrays.asList(p1,p2);
//		OrderBooking order1 = OrderBooking.builder().bookingOrderId(124).orderDate("28/7/2021").transactionMode("Card").quantity(3).totalCost(1850).planters(pp).build();
//		OrderBooking order11 = new OrderBooking(124,"28/7/2021","Cash",3,1050,order1);
		
		Optional<OrderBooking> order111 = Optional.of(OrderBooking.builder().bookingOrderId(124).transactionMode("Card").quantity(3).totalCost(1850).planters(pp).build());

		when(orepo.save(order111.get())).thenReturn(order111.get());
		when(orepo.findById(order111.get().getBookingOrderId())).thenReturn(order111);

		//equals(((IOrderService) order11.get()).viewOrder(124));
	}
	
	
		@Test
		public void testViewAllOrderBooking() {
			
			Planter p1=Planter.builder().build();
			Planter p2=Planter.builder().build();
			List<Planter> pp=Arrays.asList(p1,p2);
			List<Planter> ppp=Arrays.asList(p2,p1);
			
			List<OrderBooking> allorders = new ArrayList<OrderBooking>();
			
			OrderBooking o1= OrderBooking.builder().bookingOrderId(123).transactionMode("Cash").quantity(5).totalCost(1850).planters(pp).build();
			((IOrderService) allorders).addOrder(o1);
			
			
			OrderBooking o2= OrderBooking.builder().bookingOrderId(124).transactionMode("Card").quantity(3).totalCost(1050).planters(ppp).build();
			((IOrderService) allorders).addOrder(o2);
			when(orepo.findAll()).thenReturn(allorders);

			assertEquals(2, oservice.viewAllOrderBooking().size());
		}
	}
