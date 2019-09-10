package com.ang.test.offer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    // 20 characters
    private Long id;
    // Not Null
    // 150 characters
    // Unique
    private String name;
    // 10 integer positions, 2 decimal positions
    // No negative
    private BigDecimal price;
    // If the product gets deleted, delete also all related offers
    //private List<Offer> offers;

}
