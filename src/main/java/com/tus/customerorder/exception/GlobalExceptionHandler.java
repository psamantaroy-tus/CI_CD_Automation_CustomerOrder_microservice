package com.tus.customerorder.exception;

import com.tus.customerorder.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.tus.customerorder.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*// 1. Handle the 404 Error (using the class we just created)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
	    ErrorResponse error = new ErrorResponse(
	        HttpStatus.NOT_FOUND.value(), 
	        ex.getMessage(), 
	        null
	    );
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}*/

    // Handle 400 Bad Request (Validation Errors)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> 
            fieldErrors.put(err.getField(), err.getDefaultMessage()));

        ErrorResponse error = new ErrorResponse(400, "Validation Failed", fieldErrors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}