package com.ang.test.offer.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer implements Example<Offer> {

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
    @Lazy
    // Not null
    // Don't load it unless necessary
    private Product product;
    
    public Offer(Long id, BigDecimal discount, Date from, Date until) {
    	this.id = id;
    	discountPct = discount;
    	activeFrom = from;
    	activeUntil = until;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getDiscountPct() {
		return discountPct;
	}
	public void setDiscountPct(BigDecimal discountPct) {
		this.discountPct = discountPct;
	}
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	public Date getActiveUntil() {
		return activeUntil;
	}
	public void setActiveUntil(Date activeUntil) {
		this.activeUntil = activeUntil;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public Offer getProbe() {
		return this;
	}

	@Override
	public ExampleMatcher getMatcher() {
		// TODO Auto-generated method stub
		return null;
	}

}
