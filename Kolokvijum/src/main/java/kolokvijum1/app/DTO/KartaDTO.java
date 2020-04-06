package kolokvijum1.app.DTO;

import java.time.LocalDateTime;

public class KartaDTO {
	Long id;
	LocalDateTime kupljena;
	SedisteDTO sediste;
	
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
	public SedisteDTO getSediste() {
		return sediste;
	}
	public void setSediste(SedisteDTO sediste) {
		this.sediste = sediste;
	}
	
	
}
