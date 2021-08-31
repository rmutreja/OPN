package com.opn.in.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomerExceptionController {
	
	@ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		ResponseEntity<String> rEntity=new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	return rEntity;
		
	}
	
	@ExceptionHandler(value = CustomerException.class)
	   public ResponseEntity<Object> exception(CustomerException exception) {
	      return new ResponseEntity<>("Customer Bad request", HttpStatus.BAD_REQUEST);
	   }

}
