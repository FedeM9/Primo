package persistence.jpa;

import java.util.List;
import javax.persistence.*;
import model.Product;
import persistence.ArtistaCrudRepository;

public class ArtistaCrudRepositoryJPA implements ArtistaCrudRepository {
	private EntityManager em;
	private EntityTransaction tx;
	public  ArtistaCrudRepositoryJPA(EntityManager em) {
		this.em=em;
	
	}
	@Override
	public Product save(Product artista) { //permette di fare la persist o l'update
		if(artista.getId()==null)
			em.persist(artista);
		else
			return  em.merge(artista);  //update così l'oggetto di ritorno è managed
		return artista;
	}

	@Override
	public Product findOne(Long id) {
		return em.find(Product.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		Query query= em.createQuery("SELECT a FROM ARTISTA a");
		return query.getResultList();
	}

	@Override
	public void delete(Product artista) {
		em.remove(artista);
		
	}
	@Override
	public void deleteAll() {
		Query query=em.createQuery("DELETE FROM Artista");
		query.executeUpdate();
		
	}

}
