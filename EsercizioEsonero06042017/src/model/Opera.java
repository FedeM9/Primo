package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Opera {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String titolo;
	private String anno;
	
	@ManyToMany(mappedBy="opere")
	private List<Product> artisti;

	public Opera(){
		this.artisti=new LinkedList<>();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public List<Product> getArtisti() {
		return artisti;
	}

	public void setArtisti(List<Product> artisti) {
		this.artisti = artisti;
	}
	
	
	
}
