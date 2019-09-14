package com.ang.test.offer.exception;

public class NullIdException extends OfferAppException {
	private static final long serialVersionUID = 1L;

	public NullIdException() {
		super("offer_error.data_insuficent", null);
	}
}
