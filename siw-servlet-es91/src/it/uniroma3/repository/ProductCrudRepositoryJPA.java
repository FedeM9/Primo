package it.uniroma3.repository;

import java.util.List;
import javax.persistence.*;

import it.uniroma3.model.Product;


public class ProductCrudRepositoryJPA implements ProductCrudRepository {
	private EntityManager em;
	private EntityTransaction tx;
	public  ProductCrudRepositoryJPA(EntityManager em) {
		this.em=em;
	
	}
	@Override
	public Product save(Product product) { //permette di fare la persist o l'update
		if(product.getId()==null)
			em.persist(product);
		else
			return  em.merge(product);  //update così l'oggetto di ritorno è managed
		return product;
	}

	@Override
	public Product findOne(Long id) {
		return em.find(Product.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		Query query= em.createQuery("SELECT a FROM 	Product a");
		return query.getResultList();
	}

	@Override
	public void delete(Product prodotto) {
		em.remove(prodotto);
		
	}
	@Override
	public void deleteAll() {
		Query query=em.createQuery("DELETE FROM Artista");
		query.executeUpdate();
		
	}

}
