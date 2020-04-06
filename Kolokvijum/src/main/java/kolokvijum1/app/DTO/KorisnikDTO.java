package kolokvijum1.app.DTO;

public class KorisnikDTO {
	Long id;
	String ime;
	String prezime;
	KartaDTO karta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public KartaDTO getKarta() {
		return karta;
	}
	public void setKarta(KartaDTO karta) {
		this.karta = karta;
	}
	
	
}
