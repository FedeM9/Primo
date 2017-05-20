package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import it.uniroma3.model.Product;
import it.uniroma3.repository.ProductRepository;

public class ProductService {
	

	public ProductService() {

	}
	public Product inserisciProdotto(Product prodotto){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prodotto);
		tx.commit();
	
		return prodotto;
	}
	public List<Product> getProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		//ProductRepository rep =new  ProductRepository(this.em);
		tx.begin();
		TypedQuery<Product> query= em.createNamedQuery("findAllProducts", Product.class);
		List<Product> prodotti=query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return prodotti;
	}
	public Product getOnePrduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product prodotto = em.find(Product.class, id);
		tx.commit();
		em.close();
		emf.close();
		return prodotto;
	}
}
