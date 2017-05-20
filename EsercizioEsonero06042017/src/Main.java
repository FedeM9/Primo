
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import model.Product;
import model.Stanza;
import persistence.jpa.CrudRepository;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("museo-unit"); //importare XML
		EntityManager em=emf.createEntityManager();
		
		Product a = new Product();
		a.setNome("Paolo");
		
		Product a2 = new Product();
		a2.setNome("Marco");
		
		Stanza s = new Stanza();
		s.setNome("N11");
		s.setPiano("PT");
		Stanza s2=new Stanza();
		s2.setNome("N10");
		s2.setPiano("PT");
		
		Stanza s3=new Stanza();
		s3.setNome("N12");
		s3.setPiano("PT");		
		
		CrudRepository<Product> artistaRep= new CrudRepository<Product>(em,Product.class);
		CrudRepository<Stanza> stanzaRep = new CrudRepository<Stanza>(em,Stanza.class);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		artistaRep.save(a);
		stanzaRep.save(s);
		tx.commit();
	List<Product> artisti = artistaRep.findAll();
		for(Product art : artisti)
			System.out.println(art.toString());
		
		em.close();
		emf.close();

	}

}
