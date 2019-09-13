package com.ang.test.offer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ang.test.offer.domain.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	List<Offer> getOffersActiveToday();
}
