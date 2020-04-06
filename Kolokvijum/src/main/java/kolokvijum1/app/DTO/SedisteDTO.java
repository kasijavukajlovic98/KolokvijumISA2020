package kolokvijum1.app.DTO;

public class SedisteDTO {
	Long id;
	int red;
	int broj;
	TipSedistaDTO tipSedista;
	
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
	public TipSedistaDTO getTipSedista() {
		return tipSedista;
	}
	public void setTipSedista(TipSedistaDTO tipSedista) {
		this.tipSedista = tipSedista;
	}
	
	
		
}
