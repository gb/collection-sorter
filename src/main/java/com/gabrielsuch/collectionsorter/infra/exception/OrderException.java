package com.gabrielsuch.collectionsorter.infra.exception;

public class OrderException extends RuntimeException {
	
	private static final long serialVersionUID = -6811308898491670123L;

	public OrderException(String msg) {
		super(msg);
	}
	
	public OrderException(Throwable cause) {
		super(cause);
	}
	
	public OrderException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
