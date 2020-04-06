package kolokvijum1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolokvijum1.app.model.TipSedista;
import kolokvijum1.app.repository.TipSedistaRepository;

@Service
public class TipSedistaService {
	
	@Autowired
	TipSedistaRepository repository;
	
	public Iterable<TipSedista> dobaviSve(){
		return repository.findAll();
	}
	
	public TipSedista dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(TipSedista obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
