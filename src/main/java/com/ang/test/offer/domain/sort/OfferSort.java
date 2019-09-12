package com.ang.test.offer.domain.sort;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Sort;

public class OfferSort extends Sort {
	private static final List<String> PROPS = new LinkedList<>();
	
	static {
		PROPS.add("id");
	}
	
	public OfferSort() {
		super(Direction.ASC, PROPS);
	}
}
