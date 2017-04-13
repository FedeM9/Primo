package model;
import java.util.*;

import javax.persistence.*;

@Entity
public class Curatore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	@OneToMany
	private List<Stanza> stanze;
	
	public Curatore(){
		this.stanze=new LinkedList<>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public List<Stanza> getStanze() {
		return stanze;
	}
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}
	
	
}
