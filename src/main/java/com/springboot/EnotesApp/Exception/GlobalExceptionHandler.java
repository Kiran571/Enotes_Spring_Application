package com.springboot.EnotesApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	
//	@ExceptionHandler(NullPointerException.class)
//	public ResponseEntity<?> handleNullPointerException(Exception e){
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

		Map<String,Object> errorMessageOnPostman= new LinkedHashMap<>();
		List<ObjectError> allError=e.getBindingResult().getAllErrors();
		allError.stream().forEach(err ->{
			String msg = err.getDefaultMessage();
			String field = ((FieldError)(err)).getField();
			errorMessageOnPostman.put(field, msg);
		});	
				
		return new ResponseEntity<>(errorMessageOnPostman, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}



