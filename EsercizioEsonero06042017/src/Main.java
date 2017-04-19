
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import model.Artista;
import model.Stanza;
import persistence.ArtistaCrudRepository;
import persistence.jpa.ArtistaCrudRepositoryJPA;
import persistence.jpa.CrudRepository;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("museo-unit"); //importare XML
		EntityManager em=emf.createEntityManager();
		
		Artista a = new Artista();
		a.setNome("Paolo");
		
		Artista a2 = new Artista();
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
		
		CrudRepository<Artista> artistaRep= new CrudRepository<Artista>(em,Artista.class);
		CrudRepository<Stanza> stanzaRep = new CrudRepository<Stanza>(em,Stanza.class);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		artistaRep.save(a);
		stanzaRep.save(s);
		tx.commit();
	List<Artista> artisti = artistaRep.findAll();
		for(Artista art : artisti)
			System.out.println(art.toString());
		
		em.close();
		emf.close();

	}

}
