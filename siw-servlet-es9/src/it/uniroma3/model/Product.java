package it.uniroma3.model;


import java.util.Date;

import javax.persistence.*;


@Entity 
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String nome;	
	private String descrizione;
	private float prezzo;
	private Date dataScadenza;

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getNome() {
		return nome;
	}

	public Product(){
		
	}

	public String getName() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String description) {
		this.descrizione = description;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float price) {
		this.prezzo = price;
	}
	
		
}
