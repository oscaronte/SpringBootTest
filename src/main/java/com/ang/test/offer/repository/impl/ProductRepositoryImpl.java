package com.ang.test.offer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.domain.Product;
import com.ang.test.offer.domain.sort.ProductSort;
import com.ang.test.offer.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private EntityManager entityManager;
	
	public void saveAll(List<Product> products) {
		for(Product p: products) {
			entityManager.persist(p);
		}
	}
	
	public void saveProduct(Product p) {
		entityManager.persist(p);
	}
	
	public void deleteProduct(Product p) {
		if(p.getOffers()!=null) {
			for(Offer o: p.getOffers()) {
				entityManager.remove(o);
			}
		}
		entityManager.remove(p);
	}
	
	public Product getProduct(Product p) {
		entityManager.find(Product.class, p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll(Product p, ProductSort sort) {
		final Query query = entityManager.createQuery("SELECT * FROM Product p WHERE p.name LIKE ?");
		query.setParameter(1, p.getName());
		return query.getResultList();
	}
}
