package com.tcs.ems.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> invalidData(MethodArgumentNotValidException methodArgumentNotValidException) {
			Map<String, String> message=new HashMap<String, String>();
			
			List<FieldError> errors=methodArgumentNotValidException.getBindingResult().getFieldErrors();
			
			for(FieldError fe : errors) {
				message.put(fe.getField(), fe.getDefaultMessage());
				
			}
			
			return new ResponseEntity<Map<String,String>>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException userNotFoundException){
		return new ResponseEntity<String>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException invalidOtpException){
		return new ResponseEntity<String>(invalidOtpException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> expiredOtp(OtpExpiredException otpExpiredException){
		return new ResponseEntity<String>(otpExpiredException.getMessage(), HttpStatus.REQUEST_TIMEOUT);
	}
	
}
