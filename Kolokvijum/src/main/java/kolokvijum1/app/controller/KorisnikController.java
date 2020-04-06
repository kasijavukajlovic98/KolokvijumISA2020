package kolokvijum1.app.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum1.app.DTO.KartaDTO;
import kolokvijum1.app.DTO.KorisnikDTO;
import kolokvijum1.app.model.Karta;
import kolokvijum1.app.model.Korisnik;
import kolokvijum1.app.service.KorisnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/korisnik")
public class KorisnikController {
	
	@Autowired
	KorisnikService service;
	ArrayList<KorisnikDTO> l;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<KorisnikDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		l = new ArrayList<KorisnikDTO>();
		for(Korisnik x:service.dobaviSve()) {
			l.add(mm.map(x, KorisnikDTO.class));
		}
		
		return new ResponseEntity<ArrayList<KorisnikDTO>>(l, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Korisnik existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
		}
		KorisnikDTO obj = mm.map(existing, KorisnikDTO.class);
		return new ResponseEntity<KorisnikDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Korisnik> dodajNovi(@RequestBody Korisnik obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Korisnik>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Korisnik>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Korisnik> izmeni(@RequestBody Korisnik obj) {
    	Korisnik postoji = service.dobaviPoId(obj.getId());
        
        if (postoji == null) {
            return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
        }

        postoji.setIme(obj.getIme());
        postoji.setPrezime(obj.getPrezime());
        
        
        service.save(postoji);
        return new ResponseEntity<Korisnik>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    //Pronadji karte
    @RequestMapping(path = "/pronadjiKarte/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<KartaDTO>> pronadjiKarte(@PathVariable("id") Long id) {
    	ModelMapper mm = new ModelMapper();
		
		ArrayList<KartaDTO> lista = new ArrayList<KartaDTO>();
		for(Karta x:service.pronadjiKarte(id)) {
			lista.add(mm.map(x, KartaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<KartaDTO>>(lista, HttpStatus.OK);
    }
}
