package kolokvijum1.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum1.app.model.Sediste;

@Repository
public interface SedisteRepository extends CrudRepository<Sediste, Long>{
	
}
