package com.example.hojinToyProj.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(IllegalAccessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse IllegalAccEx(IllegalAccessException exception) {
		
		StringBuffer sb = new StringBuffer("test Exception - ");
		
		System.out.println("in Exception Manager - "+sb.append(exception.getMessage()).toString());
		return new ErrorResponse(HttpStatus.BAD_REQUEST,sb.append(exception.getMessage()).toString() );
				
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse throwableEx(Throwable throwArg) {
		
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,throwArg.toString());
	}
}
