package kolokvijum1.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sediste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	int red;
	
	@Column(nullable = false)
	int broj;
	
	@OneToOne(mappedBy = "sediste", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	TipSedista tipSedista;
	
	@OneToOne
	Karta karta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public TipSedista getTipSedista() {
		return tipSedista;
	}

	public void setTipSedista(TipSedista tipSedista) {
		this.tipSedista = tipSedista;
	}

	public Karta getKarta() {
		return karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}

	public Sediste(Long id, int red, int broj) {
		super();
		this.id = id;
		this.red = red;
		this.broj = broj;
	}
	
	public Sediste() {
		
	}
	
	
}
