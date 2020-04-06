package kolokvijum1.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum1.app.model.Karta;

@Repository
public interface KartaRepository extends CrudRepository<Karta, Long>{

}
