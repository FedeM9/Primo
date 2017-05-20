package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Product;



public interface ProductCrudRepository {
	public Product save(Product artista);
	public Product findOne(Long id);
	public List<Product> findAll();
	public void delete(Product artista);
	public void deleteAll();
}
