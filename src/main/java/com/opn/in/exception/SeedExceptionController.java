package com.opn.in.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class SeedExceptionController {
   @ExceptionHandler(value = SeedNotFoundException.class)
   public ResponseEntity<Object> exception(SeedNotFoundException exception) {
      return new ResponseEntity<>("Seed not found", HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler(value = SeedException.class)
   public ResponseEntity<Object> exception(SeedException exception) {
      return new ResponseEntity<>("Customer Bad request", HttpStatus.BAD_REQUEST);
   }
}