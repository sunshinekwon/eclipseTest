package com.example.hojinToyProj.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private final int httpStat;
	private final String message;
	
	public ErrorResponse(HttpStatus httpStat,String message) {
		this.httpStat = httpStat.value();
		this.message = message;
	}
}
