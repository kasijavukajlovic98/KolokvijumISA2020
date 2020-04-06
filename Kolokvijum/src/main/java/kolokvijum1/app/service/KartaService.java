package kolokvijum1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolokvijum1.app.model.Karta;
import kolokvijum1.app.repository.KartaRepository;


@Service
public class KartaService {
	
	@Autowired
	KartaRepository repository;
	
	public Iterable<Karta> dobaviSve(){
		return repository.findAll();
	}
	
	public Karta dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(Karta obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
