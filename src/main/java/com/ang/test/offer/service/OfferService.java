package com.ang.test.offer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.domain.Product;
import com.ang.test.offer.dto.OfferDTO;
import com.ang.test.offer.dto.ProductDTO;
import com.ang.test.offer.repository.OfferRepository;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> findAll(Date activeOn) {
    	final Offer filter = new Offer();
    	filter.setActiveUntil(activeOn);
        return offerRepository.findAll(filter);
    }

    public List<OfferDTO> findAllDTO(Date activeOn) {
        List<Offer> offers = findAll(activeOn);
        if(offers.isEmpty())
            return new ArrayList<>();
        return offers.stream().map(offer -> new OfferDTO(offer.getId()
                , offer.getDiscountPct(), offer.getActiveFrom(), offer.getActiveUntil()
                , offer.getProduct().getPrice().multiply(BigDecimal.ONE.subtract(offer.getDiscountPct()))
                , offer.getProduct().getPrice().multiply(offer.getDiscountPct())
                , new ProductDTO(
                    offer.getProduct().getId(),
                    offer.getProduct().getName(),
                    offer.getProduct().getPrice()
        ))).collect(Collectors.toList());
    }

    public List<OfferDTO> findActiveToDay() {
    	final java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
    	final List<Offer> offers = offerRepository.getOffersActiveToday(today);
    	if(offers.isEmpty())
            return new ArrayList<>();
        return offers.stream().map(offer -> new OfferDTO(offer.getId()
                , offer.getDiscountPct(), offer.getActiveFrom(), offer.getActiveUntil()
                , offer.getProduct().getPrice().multiply(BigDecimal.ONE.subtract(offer.getDiscountPct()))
                , offer.getProduct().getPrice().multiply(offer.getDiscountPct())
                , new ProductDTO(
                    offer.getProduct().getId(),
                    offer.getProduct().getName(),
                    offer.getProduct().getPrice()
        ))).collect(Collectors.toList());
    }
    
    public Offer save(Offer offer) {
    	
        return offerRepository.save(offer);
    }

    public OfferDTO save(OfferDTO offerDTO) {
        Offer offer = new Offer(
                offerDTO.getId(),
                offerDTO.getDiscountPct(),
                offerDTO.getActiveFrom(),
                offerDTO.getActiveUntil(),
                new Product(
                        offerDTO.getProduct().getId(),
                        offerDTO.getProduct().getName(),
                        offerDTO.getProduct().getPrice()
                )
        );
        Offer saved = save(offer);
        return new OfferDTO(saved.getId()
                , saved.getDiscountPct(), saved.getActiveFrom(), saved.getActiveUntil()
                , saved.getProduct().getPrice().multiply(BigDecimal.ONE.subtract(saved.getDiscountPct()))
                , saved.getProduct().getPrice().multiply(saved.getDiscountPct())
                , new ProductDTO(
                saved.getProduct().getId(),
                saved.getProduct().getName(),
                saved.getProduct().getPrice()
        ));
    }

}
