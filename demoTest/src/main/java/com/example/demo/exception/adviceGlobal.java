package com.example.demo.exception;



import com.example.demo.entity.errorModel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class adviceGlobal {
 
	
	//MethodArgumentNotValidException handled here
	@Value("${exception.msg1:Default Message}")
	private String msg1;
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleNotValidException(MethodArgumentNotValidException ex){
		log.warn(msg1);
		return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
		
	}
	//NullPointerException handled here
	@Value("${exception.msg2:Default Message}")
	private String msg2;
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNoSuch(NullPointerException ex){
		log.warn(msg2);
		return new ResponseEntity<String>(msg2,HttpStatus.BAD_REQUEST);
		
	}
	//EmptyResultDataAccessException handled here
	@Value("${exception.msg3:Default Message}")
	private String msg3;
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResult(EmptyResultDataAccessException ex){
		log.warn(msg3);
		return new ResponseEntity<>(msg3,HttpStatus.NOT_FOUND);
		
	}
	
	  //Custom Exception handled here
	
		@ExceptionHandler(customException.class)
		public ResponseEntity<errorModel> customExceptionUpdate(customException ex){
			errorModel model=new errorModel(ex.getMessage());
			return new ResponseEntity<>(model,HttpStatus.BAD_REQUEST);
			
		}

		
}
