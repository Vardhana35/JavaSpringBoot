package com.tcs.ass_s2.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleBeanObject(MethodArgumentNotValidException me) {
		BindingResult br = me.getBindingResult();
		Map<String, String> map = new HashMap<>();
		/*
		 * List<FieldError> list=br.getFieldErrors(); for(FieldError er:list) { String
		 * field=er.getField(); String message=er.getDefaultMessage();
		 * map.put(field,message); }
		 */
		br.getFieldErrors().forEach(x -> map.put(x.getField(), x.getDefaultMessage()));
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(exception = NullPointerException.class)
	public ResponseEntity<Map<String, String>> handleNullPointerException(NullPointerException ne) {
		Map<String, String> map = new HashMap<>();
		map.put("errorCode", "103");
		map.put("errorMessage", "There is some null pointer exception");
		map.put("details", ne.getMessage());
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleException(RuntimeException rte) {
		Map<String, String> map = new HashMap<>();
		map.put("errorCode", "105");
		map.put("errorMessage", "run time error");
		map.put("details", rte.getMessage());
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
