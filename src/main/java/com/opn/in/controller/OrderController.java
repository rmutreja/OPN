package com.opn.in.controller;

import java.util.List;
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
import com.opn.in.entity.OrderBooking;
import com.opn.in.exception.OrderNotFoundException;
import com.opn.in.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/OrderBooking")
@Api(description="this is order Controller to perform operations")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);	

	@Autowired
	private IOrderService OrderService;
		
	/*{
	 	"bookingOrderId": 124,
  		"orderDate": "30/7/2021",
  		"quantity": 3,
  		"totalCost": 1040,
  		"transactionMode": "Online"
  	}	
	 * http://localhost:8080/OrderBooking/addOrder
	 * This url is responsible for adding a order
	 * HTTP Method POST is required
	 */
    @ApiOperation(value="This is addorder method() to add order to the table")
	@PostMapping(path = "/addOrder")
	public ResponseEntity<OrderBooking> addOrder(@RequestBody OrderBooking Order) throws OrderNotFoundException {
	try {
			logger.info("Trying to add Record  : " + Order);
			OrderService.addOrder(Order);
			return new ResponseEntity<>(Order, HttpStatus.CREATED);
			
	} catch (Exception e) {
			logger.error("Record NOT Added  : " + Order);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			
		}
	}

	
    /*
	 * http://localhost:8080/OrerBooking/getAllOrder/1
	 * This url is responsible for getting all orders
	 * HTTP Method GET is required
	 */ 
    @ApiOperation(value="This is getAllOrder method() to view all the order in the table")
	@GetMapping(path = "/getAllOrder/{id}")
	public ResponseEntity<List<OrderBooking>> getAllOrder() throws OrderNotFoundException {
		logger.info("Trying to fetch User list ");
		try {
			List<OrderBooking> Order = OrderService.viewAllOrderBooking();
			
			if(Order.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Order, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Record NOT found");
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	/*
	 * http://localhost:8080/OrderBooking/getOrder/1	
	 * This url is responsible for getting order by Id
	 * HTTP Method GET is required
	 */
    @ApiOperation(value="This is getOrderById method() to view order by id in the table")
	@GetMapping(path = "/getOrder/{id}")
	public ResponseEntity<OrderBooking> getOrderById(@PathVariable Integer id) throws OrderNotFoundException {
		logger.info("Trying to search Record with Id : " + id);
		try {
			OrderBooking order=OrderService.viewOrder(id);
			return new ResponseEntity<OrderBooking>(order,HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("Record NOT Found with Id : " + id);
			return new ResponseEntity<OrderBooking>(new OrderBooking(), HttpStatus.EXPECTATION_FAILED);
		}
	}

		
	/*
	 * http://localhost:8080/OrderBooking/deleteOrder/1
	 * This url is responsible for deleting a order
	 * HTTP Method DELETE is required
	 */
    @ApiOperation(value="This is deleteOrder method() to delete order in the table")
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) throws OrderNotFoundException {
		
		try {
			OrderService.deleteOrder(id);
			OrderService.viewOrder(id);
			logger.info("Record Deleted with Id : " + id);
			return new ResponseEntity<>("Record Deleted...with id : "+id,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Record NOT Deleted with Id : " + id);
			return new ResponseEntity<>("Record not found with id : "+id,HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	/*
	 * http://localhost:8080/OrderBooking/updateOrder/1
	 * This url is responsible for updating a order
	 * HTTP Method PUT is required
	 */
    @ApiOperation(value="This is updateOrder method() to update the order in the table")
    @PutMapping("/updateOrder/{id}")
	public ResponseEntity<OrderBooking> updateOrder(@RequestBody OrderBooking order, @PathVariable Integer id)
			throws OrderNotFoundException {
		
		try{
			OrderBooking update=OrderService.addOrder(order);
		
		return new ResponseEntity<OrderBooking>(update,HttpStatus.CREATED);
		
		}catch(Exception e) {
			
			logger.error("Record NOT Updated  : " + order);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	

}