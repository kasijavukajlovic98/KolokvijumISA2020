package kolokvijum1.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum1.app.model.TipSedista;

@Repository
public interface TipSedistaRepository extends  CrudRepository<TipSedista, Long>{

}
