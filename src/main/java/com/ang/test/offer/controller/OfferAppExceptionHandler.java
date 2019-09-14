package com.ang.test.offer.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ang.test.offer.exception.OfferAppException;
import com.ang.test.offer.util.OfferMessage;

@ControllerAdvice
public class OfferAppExceptionHandler {
	private final static String UNEXPECTED = "offer_error.unexpected";
	private final MessageSource messageSource;
	
	@Autowired
	public OfferAppExceptionHandler(MessageSource ms) {
		messageSource = ms;
	}
	
	@ExceptionHandler(OfferAppException.class)
	public ResponseEntity<OfferMessage> handleOfferAppException(OfferAppException exception, Locale locale) {
		String message = messageSource.getMessage(exception.getMessage(), exception.getArgs(), locale);
		return new ResponseEntity<>(new OfferMessage(message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<OfferMessage> handleUnexpectedError(Exception ex, Locale locale) {
		String message = messageSource.getMessage(UNEXPECTED, null, locale);
		return new ResponseEntity<>(new OfferMessage(message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
