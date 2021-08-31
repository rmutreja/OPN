package com.opn.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginExceptionController {
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<String> handleLoginExceptionAction(LoginException excep) {
		ResponseEntity<String> entity = new ResponseEntity<String>(excep.toString(), HttpStatus.NOT_FOUND);
		return entity;
		
	}	

}
