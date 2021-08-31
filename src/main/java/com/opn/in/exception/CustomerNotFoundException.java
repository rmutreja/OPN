package com.opn.in.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class CustomerNotFoundException extends RuntimeException 
   {
 
		private static final long serialVersionUID= 1L;
		private static final Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);
		String message;
	
	
	 public CustomerNotFoundException(String message)
	 {
		 this.message= message;
		 logger.info(message);
	 }
	 
	 @Override
	 public String toString() {
		 return message;
	 }
}
