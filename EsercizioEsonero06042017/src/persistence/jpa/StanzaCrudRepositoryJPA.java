package persistence.jpa;

import java.util.List;
import javax.persistence.*;
import model.Stanza;

public class StanzaCrudRepositoryJPA extends CrudRepository{

	public StanzaCrudRepositoryJPA(EntityManager em) {
		super(em, Stanza.class);
		
	}
	
	public List<Stanza> findStanzeByPiano(String piano){
		TypedQuery<Stanza> query = this.getEm().createQuery("SELECT s FROM Stanza WHERE s.piano = "+piano,Stanza.class);
		return query.getResultList();
	}

}
