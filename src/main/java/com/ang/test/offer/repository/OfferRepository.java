package com.ang.test.offer.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ang.test.offer.domain.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	@Query("SELECT offer FROM Offer offer WHERE offer.activeFrom>=:actualDate AND offer.activeUntil<=:actualDate")
	List<Offer> getOffersActiveToday(@Param("actualDate") Date actualDate);
}
