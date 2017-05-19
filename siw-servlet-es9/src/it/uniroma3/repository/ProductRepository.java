package it.uniroma3.repository;

import javax.persistence.EntityManager;


import it.uniroma3.model.Product;

public class ProductRepository extends CrudRepositoryJPA<Product> {

	public ProductRepository(EntityManager em) {
		super(em, Product.class);
	}
	

}
