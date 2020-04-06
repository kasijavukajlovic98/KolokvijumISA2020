package kolokvijum1.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kolokvijum1.app.model.Karta;
import kolokvijum1.app.model.Korisnik;



@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Long>{
	
	@Query("SELECT k FROM Karta k WHERE k.sediste.tipSedista.id = :tipid")
	public Iterable<Karta> pronadjiKarte(@Param("tipid") Long id);
}
