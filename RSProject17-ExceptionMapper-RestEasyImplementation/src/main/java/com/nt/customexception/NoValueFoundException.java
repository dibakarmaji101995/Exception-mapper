package com.nt.customexception;

public class NoValueFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoValueFoundException() {
		System.out.println("NoValueFoundException.NoValueFoundException()");
	}
	public NoValueFoundException(String msg) {
		super(msg);
	}

}
