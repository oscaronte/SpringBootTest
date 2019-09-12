package com.ang.test.offer.repository;

import com.ang.test.offer.domain.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	void saveAll(List<Product> products);
	void saveProduct(Product p);
	void deleteProduct(Product p);
	Product getProduct(Product p);
}
