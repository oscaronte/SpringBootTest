package com.ang.test.offer.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Example<Product> {

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
    private List<Offer> offers;

    public Product(Long id, String name, BigDecimal price) {
    	this.id= id;
    	this.name= name;
    	this.price = price;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	@Override
	public Product getProbe() {
		return this;
	}

	@Override
	public ExampleMatcher getMatcher() {
		// TODO Auto-generated method stub
		return null;
	}

}
