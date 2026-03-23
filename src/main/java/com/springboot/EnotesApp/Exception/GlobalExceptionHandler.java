package com.springboot.EnotesApp.Exception;

import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
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
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
//
//		Map<String,Object> errorMessageOnPostman= new LinkedHashMap<>();
//		List<ObjectError> allError=e.getBindingResult().getAllErrors();
//		allError.stream().forEach(err ->{
//			String msg = err.getDefaultMessage();
//			String field = ((FieldError)(err)).getField();
//			errorMessageOnPostman.put(field, msg);
//		});	
//				
//		return new ResponseEntity<>(errorMessageOnPostman, HttpStatus.BAD_REQUEST);
//	}
	
	 // ✅ Handles validation errors for @RequestBody DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // ✅ Handles validation errors for @Validated or method-level validation (Spring Boot 3+)
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleHandlerMethodValidation(HandlerMethodValidationException ex) {
        Map<String, String> errors = new HashMap<>();
//        ex.getAllErrors().forEach(error -> {
//            String field = error.contains(TypeMismatchException.class)
//                    ? "Invalid field"
//                    : error.getObjectName();
//            errors.put(field, error.getDefaultMessage());
//        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String , String>> handleValidationException(MethodArgumentNotValidException ex){
//		Map<String,String> errors = new HashMap<>();
//		System.out.println(ex.getBindingResult());
//		System.out.println(ex.getBindingResult().getFieldErrors());
//		ex.getBindingResult().getFieldErrors().forEach(error ->
//		errors.put(error.getField(), error.getDefaultMessage())
//				);
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
	
}



