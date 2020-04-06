package kolokvijum1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolokvijum1.app.model.Karta;
import kolokvijum1.app.model.Korisnik;
import kolokvijum1.app.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository repository;
	
	public Iterable<Korisnik> dobaviSve(){
		return repository.findAll();
	}
	
	public Korisnik dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(Korisnik obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Iterable<Karta> pronadjiKarte(Long id) {
		return repository.pronadjiKarte(id);
	}
}
