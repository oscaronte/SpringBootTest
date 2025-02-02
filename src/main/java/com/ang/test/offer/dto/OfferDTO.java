package com.ang.test.offer.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {

	@Generated
    private Long id;
    // Between 0 and 1
    @NonNull
    private BigDecimal discountPct;
    // Mandatory
    // Output format: MM/dd/yyyy
    // Input format: MM/dd/yyyy
    @NonNull
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
    @NonNull
    private ProductDTO product;
    
	
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
	public BigDecimal getDiscountedPrice() {
		if(discountedPrice==null) {
			discountedPrice = discountPct.multiply(product.getPrice());
		}
		return discountedPrice;
	}
	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public BigDecimal getSaving() {
		if(saving==null) {
			saving = product.getPrice().subtract(getDiscountedPrice());
		}
		return saving;
	}
	public void setSaving(BigDecimal saving) {
		this.saving = saving;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}

    
}
