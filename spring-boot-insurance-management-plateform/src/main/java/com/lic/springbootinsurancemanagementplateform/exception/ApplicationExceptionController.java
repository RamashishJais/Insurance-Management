package com.lic.springbootinsurancemanagementplateform.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionController {

	@Autowired
	ResponseStructure<String>  responseStructure;
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdExceptionHandler(IdNotFoundException exception){
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMsg(exception.getMessage());
		responseStructure.setDescription("Please pass the Id what is present in current table.....");
		responseStructure.setData(null);
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
