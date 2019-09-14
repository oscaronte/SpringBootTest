package com.ang.test.offer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OfferAppException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private Object[] args;
	
}
