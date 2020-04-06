package kolokvijum1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolokvijum1.app.model.Sediste;
import kolokvijum1.app.repository.SedisteRepository;

@Service
public class SedisteService {
	@Autowired
	SedisteRepository repository;
	
	public Iterable<Sediste> dobaviSve(){
		return repository.findAll();
	}
	
	public Sediste dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(Sediste obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
