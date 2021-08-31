package com.opn.in.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PlanterExceptionController {
   @ExceptionHandler(value = PlanterNotFoundException.class)
   public ResponseEntity<Object> exception(PlanterNotFoundException exception) {
      return new ResponseEntity<>("Planter not found", HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler(value = PlanterException.class)
   public ResponseEntity<Object> exception(PlanterException exception) {
      return new ResponseEntity<>("Customer Bad request", HttpStatus.BAD_REQUEST);
   }
}