package com.ang.test.offer.util;

import java.util.List;

import lombok.Getter;

@Getter
public class OfferMessage {
	private String message;
	private List<String> messages;
	
	public OfferMessage(String message) {
		this.message = message;
	}
	
	public OfferMessage(List<String> messages) {
		this.messages = messages;
	}
}
