package com.ang.test.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {

    private Long id;
    // Between 0 and 1
    private BigDecimal discountPct;
    // Mandatory
    // Output format: MM/dd/yyyy
    // Input format: MM/dd/yyyy
    private Date activeFrom;
    // Optional
    // Output format: MM/dd/yyyy
    // Input format: MM/dd/yyyy
    private Date activeUntil;
    // Calculated
    private BigDecimal discountedPrice;
    // Calculated
    private BigDecimal saving;
    // Product ID is mandatory
    private ProductDTO product;

}
