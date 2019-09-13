package com.ang.test.offer.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ang.test.offer.dto.OfferDTO;
import com.ang.test.offer.service.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferController {

	private OfferService offerService;

	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}

	@GetMapping("/list")
	public ResponseEntity<List<OfferDTO>> findAllActive(
			@RequestParam(value = "activeFrom", required = false) Date activeOn) {
		List<OfferDTO> result;

		if (activeOn != null) {
			result = offerService.findAllDTO(activeOn);
		} else {
			result = offerService.findActiveToDay();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<OfferDTO> add(@Valid OfferDTO offerDTO) {
		offerDTO.setId(null);
		return new ResponseEntity<>(offerService.save(offerDTO), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<OfferDTO> edit(@Valid OfferDTO offerDTO) {
		// Null IDs are not allowed
		return new ResponseEntity<>(offerService.save(offerDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<OfferDTO> delete(Long id) {
		return new ResponseEntity<>(new OfferDTO(), HttpStatus.OK);
	}
}
