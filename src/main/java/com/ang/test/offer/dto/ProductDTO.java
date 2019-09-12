package com.ang.test.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    // Not null
    // 150 chars
    // Prevent XSS
    private String name;
    // 10 integer positions, 2 decimal positions
    // No negative
    private BigDecimal price;

}
