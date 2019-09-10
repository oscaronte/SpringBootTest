package com.ang.test.offer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue
    // 20 characters
    private Long id;
    // Not null
    // 1 integer character, 2 decimal characters
    private BigDecimal discountPct;
    // Not null
    private Date activeFrom;
    // Nullable (Null means that this offer will be valid for undefined time)
    private Date activeUntil;
    @ManyToOne
    // Not null
    // Don't load it unless necessary
    private Product product;

}
