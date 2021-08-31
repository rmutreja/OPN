package com.opn.in.service;

import java.util.List;
import com.opn.in.entity.OrderBooking;

public interface IOrderService {
	
	//Integer addOrder = null;
	
	public OrderBooking addOrder(OrderBooking order);
	public OrderBooking updateOrder(OrderBooking Order, Integer id) throws Throwable;
	public void deleteOrder(Integer orderId);
	public OrderBooking viewOrder(Integer orderId);
	List<OrderBooking> viewAllOrderBooking();

}

