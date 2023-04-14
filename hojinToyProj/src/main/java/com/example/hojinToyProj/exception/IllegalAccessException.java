package com.example.hojinToyProj.exception;


public class IllegalAccessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalAccessException() {
		super("잘못된 접근입니다.");
	}

}
