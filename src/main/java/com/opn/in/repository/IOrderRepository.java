package com.opn.in.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.demo.controller.OrderBooking;
import com.opn.in.entity.OrderBooking;

@Repository
public interface IOrderRepository extends JpaRepository<OrderBooking, Integer> 
{
	
}
