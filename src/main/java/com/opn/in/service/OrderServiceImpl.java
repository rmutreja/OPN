package com.opn.in.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opn.in.entity.OrderBooking;
import com.opn.in.repository.IOrderRepository;
import com.opn.in.exception.OrderNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService {
	
	
	@Autowired
	private IOrderRepository orepo;
	
	@Override
	public OrderBooking addOrder(OrderBooking Order)
	{
		OrderBooking op= orepo.save(Order);
		return op;
	}
	
	@Override
	public OrderBooking updateOrder(OrderBooking Order, Integer orderId) throws Throwable
	{
		java.util.Optional<OrderBooking> searchOrder= orepo.findById(orderId);
		if(searchOrder.isPresent())
		{
			return orepo.save(Order);
			
		}
		else
		{
			throw new Exception("Order with given Id :"+orderId+"Not Available");
		}
	}
	
	@Override
	public void deleteOrder(Integer orderId)
	{
		java.util.Optional<OrderBooking> searchOrder= orepo.findById(orderId);
		if(searchOrder.isPresent())
		{
			orepo.deleteById(orderId);
			
		}
		else
		{
			throw new OrderNotFoundException("Order with given Id :"+orderId+"Not Available");
		}
	}

	@Override
	public OrderBooking viewOrder(Integer orderId) throws OrderNotFoundException
	{
		return orepo.findById(orderId).orElseThrow();
	}

	@Override
	public List<OrderBooking> viewAllOrderBooking() {
		List<OrderBooking> allOrderBooking = orepo.findAll();
		return allOrderBooking;
	}

}
