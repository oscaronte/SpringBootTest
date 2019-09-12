package com.ang.test.offer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ang.test.offer.domain.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	Offer getOffer(Offer o);
	void deleteOffer(Offer o);
	void saveOffer(Offer o);
	void saveAll(List<Offer> offers);
}
