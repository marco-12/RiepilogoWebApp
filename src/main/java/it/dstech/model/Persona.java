package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	
	private String cognome;
	
	private String eta;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}

	public Persona() {
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}
	
	

}
