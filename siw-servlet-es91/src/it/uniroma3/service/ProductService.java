package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import it.uniroma3.model.Product;
import it.uniroma3.repository.ProductCrudRepositoryJPA;

public class ProductService {
	

	public ProductService() {

	}
	public Product inserisciProdotto(Product prodotto){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		ProductCrudRepositoryJPA rep = new ProductCrudRepositoryJPA(em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		prodotto=rep.save(prodotto);
		tx.commit();
		return prodotto;
	}
	public List<Product> getProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ProductCrudRepositoryJPA rep =new ProductCrudRepositoryJPA(em);
		tx.begin();

		List<Product> prodotti=rep.findAll();
		tx.commit();

		return prodotti;
	}
	public Product getOnePrduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ProductCrudRepositoryJPA rep =new ProductCrudRepositoryJPA(em);
		tx.begin();
		Product prodotto = rep.findOne(id);
		tx.commit();
		return prodotto;
	}
	public void remove(Product prodotto){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ProductCrudRepositoryJPA rep =new ProductCrudRepositoryJPA(em);
		tx.begin();
		rep.delete(prodotto);
		tx.commit();	
	}
}
