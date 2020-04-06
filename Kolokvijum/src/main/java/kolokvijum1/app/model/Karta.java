package kolokvijum1.app.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Karta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	LocalDateTime kupljena;
	
	@OneToOne(mappedBy = "karta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Sediste sediste;
	
	@OneToOne
	Korisnik korisnik;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getKupljena() {
		return kupljena;
	}

	public void setKupljena(LocalDateTime kupljena) {
		this.kupljena = kupljena;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Karta(Long id, LocalDateTime kupljena) {
		super();
		this.id = id;
		this.kupljena = kupljena;
	}
	
	public Karta() {
		
	}
}
