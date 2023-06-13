package com.example.assignment.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ContactException.class)
	public ResponseEntity<MyErrorDetail> contactException(ContactException ce, WebRequest wr){
		
		MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(), ce.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(error, HttpStatusCode.valueOf(404));
	}
}
