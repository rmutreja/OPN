package com.opn.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlantExceptionController {
	
	@ExceptionHandler(value = PlantNotFoundException.class)
		public ResponseEntity<Object> exception(PlantNotFoundException exception) {
		return new ResponseEntity<>("Plant not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PlantException.class)
		public ResponseEntity<Object> exception(PlantException exception) {
		return new ResponseEntity<>("Customer Bad request", HttpStatus.BAD_REQUEST);
	}
	

}
